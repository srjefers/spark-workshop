import org.apache.spark.sql.SparkSession

object EmailClassificationApp extends App {

  // FIXME Use scopt for command-line options
  val inputCol = args(0) // "body"
  val trainingDataCsvFile = args(1)
  val prodDataCsvFile = args(2)

  import org.apache.spark.ml.classification.LogisticRegression
  val logReg = new LogisticRegression

  import org.apache.spark.ml.feature.Tokenizer
  val tok = new Tokenizer().setInputCol(inputCol)

  import org.apache.spark.ml.feature.HashingTF
  val hashTF = new HashingTF()
    .setInputCol(tok.getOutputCol)
    .setOutputCol(logReg.getFeaturesCol)

  import org.apache.spark.ml.Pipeline
  val pipeline = new Pipeline().setStages(Array(tok, hashTF, logReg))

  val spark = SparkSession.builder.getOrCreate
  val opts = Map("header" -> true.toString, "inferSchema" -> true.toString)
  val trainingData = spark.read.options(opts).csv(trainingDataCsvFile)
  val prodData = spark.read.options(opts).csv(prodDataCsvFile)

  // FIXME Get rid of this ugly if and create two different apps
  val modelDir = "classification-model"
  import java.io.File
  val model = if (new File(modelDir).exists()) {
    println(s">>> Model is available (dir: $modelDir)")
    import org.apache.spark.ml.tuning.CrossValidatorModel
    CrossValidatorModel.load(modelDir)
  } else {
    println(">>> Model is NOT available. Fitting a model")
    val Array(trainData, testData) = trainingData.randomSplit(Array(0.7, 0.3))
    val m = pipeline.fit(trainData)

    println(">>> Testing the model")
    val testPredictions = m.transform(testData)

    println(">>> Evaluating the model")
    import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
    val evaluator = new BinaryClassificationEvaluator

    println(s">>> >>> Model evaluation score: ${evaluator.evaluate(testPredictions)}")

    println(s">>> CrossValidating the pipeline")
    import org.apache.spark.ml.param.ParamMap
    import org.apache.spark.ml.tuning.ParamGridBuilder
    val paramGrid: Array[ParamMap] = new ParamGridBuilder().
      addGrid(logReg.elasticNetParam, Seq(0.5,0.75,1.0)).
      build
    import org.apache.spark.ml.tuning.CrossValidator
    val cv = new CrossValidator()
        .setEstimator(pipeline)
        .setEvaluator(evaluator)
        .setEstimatorParamMaps(paramGrid)
    val bestModel = cv.fit(trainingData)

    println(s">>> Persisting the model to $modelDir")
    bestModel.write.overwrite().save(modelDir)

    println(">>> >>> Best model params")
    import org.apache.spark.ml.PipelineModel
    import org.apache.spark.ml.Pipeline
    val elasticNetParam = bestModel
      .bestModel.asInstanceOf[PipelineModel]
      .parent.asInstanceOf[Pipeline]
      .getStages(2).asInstanceOf[LogisticRegression]
      .getElasticNetParam
    println(s">>> >>> >>> elasticNetParam = $elasticNetParam")

    bestModel
  }

  val predictions = model.transform(prodData)

  import spark.implicits._
  import org.apache.spark.sql.functions.when
  val status = when('prediction === 0, "OK").otherwise("SPAM").as("status")
  predictions.select('body, status).show
}
