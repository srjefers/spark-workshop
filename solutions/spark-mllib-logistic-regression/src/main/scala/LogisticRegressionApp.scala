package com.valueamplify.spark

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{HashingTF, RegexTokenizer}
import org.apache.spark.sql.SparkSession

object LogisticRegressionApp extends App {

  // Step 1: Start Spark infrastructure
  val spark = SparkSession.builder().master("local[*]").getOrCreate()
  import spark.implicits._

  // Step 2: Read the dataset to process
  case class Article(id: Long, topic: String, text: String)
  val articles = spark.read.json("src/main/resources/articles.json")

  import org.apache.spark.sql.functions.udf
  val topic2Label: Boolean => Double = isSci => if (isSci) 1 else 0
  val toLabel = udf(topic2Label)
  val labelled = articles.withColumn("label", toLabel('topic.like("sci%"))).cache

  labelled.show

  // Step 3: Define a ML Pipeline for LogisticRegression classification
  val regTok = new RegexTokenizer().setInputCol("text").setOutputCol("words")
  val hashTF = new HashingTF().setInputCol("words").setOutputCol("features")
  val logReg = new LogisticRegression().setMaxIter(20).setRegParam(0.01)

  val pipeline = new Pipeline().setStages(Array(regTok, hashTF, logReg))

  // Step 4: Split the input dataset to training and testing datasets
  val Array(trainingDF, testingDF) = labelled.randomSplit(Array(0.6, 0.4))

  // Step 5: Train the model
  val model = pipeline.fit(trainingDF)

  // Step 6: Calculate predictions on testing dataset
  val predictions = model.transform(testingDF)

  // Step 7: Show the results
  predictions.select('id, 'topic, 'text, 'label, 'prediction).show

  // Step 8: Evaluate the model
  import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
  val evaluator = new BinaryClassificationEvaluator().setMetricName("areaUnderROC")

  import org.apache.spark.ml.param.ParamMap
  val evaluatorParams = ParamMap(evaluator.metricName -> "areaUnderROC")

  val testingAuROC = evaluator.evaluate(predictions, evaluatorParams)
  println(s"The area under ROC is $testingAuROC")

  // Step 9: Tune the hyperparameters of the ML algorithm
  import org.apache.spark.ml.tuning.ParamGridBuilder
  val paramGrid = new ParamGridBuilder()
    .addGrid(hashTF.numFeatures, Array(100, 1000))
    .addGrid(logReg.regParam, Array(0.05, 0.2))
    .addGrid(logReg.maxIter, Array(5, 10, 15))
    .build

  import org.apache.spark.ml.tuning.CrossValidator
  val cv = new CrossValidator()
    .setEstimator(pipeline)
    .setEstimatorParamMaps(paramGrid)
    .setEvaluator(evaluator)
    .setNumFolds(10)

  // Step 10: Train the best model given the parameters
  val cvModel = cv.fit(trainingDF)
  val predictionsAfterTuning = cvModel.transform(testingDF)
  predictionsAfterTuning.select('id, 'topic, 'text, 'label, 'prediction).show

  // Step 11: Compare results
  val tunedAuROC = evaluator.evaluate(predictionsAfterTuning, evaluatorParams)

  println(s"\n>>> The area under ROC was $testingAuROC and is $tunedAuROC (after tuning)\n")

  // Step 12: Save the model for later use
  cvModel.write.overwrite.save("model")

  // Step 13: Stop Spark infrastucture
  spark.stop
}
