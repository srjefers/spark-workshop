import org.apache.spark.sql.SparkSession
import org.scalatest._

class MfFormatSpec extends FlatSpec with Matchers {

  "Spark" should "read mf files" in {
    val spark = SparkSession.builder.master("local").getOrCreate
    try {
      val df = spark.read.format("pl.japila.spark.mf").load("src/test/resources/file.mf")
      df.show
      // TODO Have a proper assertion here
    } finally {
      spark.stop
    }
  }
}
