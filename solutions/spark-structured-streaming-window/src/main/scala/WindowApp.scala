import java.sql.Timestamp

import org.apache.log4j.{Level, LogManager}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.streaming.MemoryStream
import org.apache.spark.sql.streaming.OutputMode

object WindowApp extends App {

  LogManager.getLogger("org").setLevel(Level.OFF)

  val spark = SparkSession.builder
    .appName("Window support in Structured Streaming")
    .master("local[*]")
    .getOrCreate()

  import spark.implicits._

  implicit val sqlContext = spark.sqlContext

  case class TimedEvent(id: Long, value: Int, time: Timestamp)

  val intsInput = MemoryStream[TimedEvent]

  import org.apache.spark.sql.functions._

  val query = intsInput.toDS
    .groupBy(window('time, "1 seconds"))
    .agg(sum('value) as "sum")
    .sort('window)
    .writeStream
    .format("console")
    .outputMode(OutputMode.Complete)
    .option("truncate", false)
    .start

  (0 to 5).foreach { batch =>
    intsInput.addData(
      TimedEvent(batch + 0, batch * 2, new Timestamp(System.currentTimeMillis())),
      TimedEvent(batch + 1, batch * 3, new Timestamp(System.currentTimeMillis() + 1000)))
    Thread.sleep(1000 * batch)
  }

  query.awaitTermination(1000 * (0 to 5).sum)
  spark.stop()
}
