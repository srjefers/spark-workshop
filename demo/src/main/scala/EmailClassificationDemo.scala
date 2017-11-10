package pl.japila.spark

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{HashingTF, Tokenizer}
import org.apache.spark.sql.SparkSession

object EmailClassificationDemo extends App {

  // Step 1. Load your dataset
  val spark = SparkSession.builder.getOrCreate
  val emails = spark
    .read
    .option("header", true)
    .option("inferSchema", true)
    .csv(args(0))

  // Step 2. Instantiate ML Algorithm / Estimator
  val lr = new LogisticRegression()

  // Step 3. Instantiate Transformers
  val tok = new Tokenizer()
    .setInputCol("body")
  val hashTF = new HashingTF()
    .setInputCol(tok.getOutputCol)
    .setOutputCol("features")

  // Step 4. Instantiate a Pipeline
  val pipeline = new Pipeline().
    setStages(Array(tok, hashTF, lr))

  // Step 5. Randomly split the input dataset
  val Array(training, testing) =
    emails.randomSplit(Array(0.6, 0.4))

  val model = pipeline.fit(training)

  val predictions = model.transform(testing)

  predictions.select("rawPrediction", "label", "prediction").show

  import org.apache.spark.sql.functions._
  import spark.implicits._

  predictions
    .withColumn("meaning",
      when($"prediction" === 0.0, "SPAM").otherwise("NOT SPAM"))
    .select("body", "meaning")
    .show

  // FIXME You may want to use CrossValidator to train the best model
}
