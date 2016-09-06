import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.MultinomialLogisticRegression
import org.apache.spark.ml.feature.{HashingTF, RegexTokenizer}
import org.apache.spark.sql.SparkSession

object MultinomialLogisticRegressionApp extends App {
  val spark = SparkSession.builder.master("local[*]").getOrCreate
  import spark.implicits._

  val input = Seq(
    (0, "hello redmond"),
    (1, "and this is something slightly longer")).toDF("label", "text").as[(String, String)]

  val regTok = new RegexTokenizer().setInputCol("text").setOutputCol("words")
  val hashTF = new HashingTF().setInputCol("words").setOutputCol("features")
  val multiLogReg = new MultinomialLogisticRegression().setRegParam(0.01).setMaxIter(100)

  val Array(training, test) = input.randomSplit(Array(0.8, 0.2))

  val pipeline = new Pipeline().setStages(Array(regTok, hashTF, multiLogReg))

  val model = pipeline.fit(training)
  val predictions = model.transform(test)

  predictions.select('label, 'text, 'prediction).show(truncate = false)

  spark.stop()
}
