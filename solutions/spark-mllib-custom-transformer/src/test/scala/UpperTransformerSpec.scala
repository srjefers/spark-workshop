import org.apache.log4j.{Level, LogManager}
import org.apache.spark.sql.SparkSession
import org.scalatest.FlatSpec

class UpperTransformerSpec extends FlatSpec {
  "A UpperTransformer" should "transform string column to upper" in {
    val upp = new UpperTransformer()

    LogManager.getRootLogger.setLevel(Level.OFF)
    LogManager.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder.master("local").getOrCreate
    import spark.implicits._

    // FIXME Use ScalaCheck to generate a random Dataset
    val df = Seq(
      (0, "UpperTransformerSpec", true),
      (1, "upper Transformer spec", false)).toDF("id", "title", "required")

    val result = upp.setInputCol("title")
      .transform(df)
      .select(upp.getOutputCol)
      .as[String]
      .collect()

    assert(result.forall(s => s.toUpperCase == s))
  }
}
