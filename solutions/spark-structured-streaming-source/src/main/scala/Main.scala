package pl.japila.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.Trigger

object Main extends App {

  val spark = SparkSession.builder.getOrCreate

  import scala.concurrent.duration._
  val q = spark
    .readStream
    .format("amadeus")
    .load
    .writeStream
    .format("console")
    .trigger(Trigger.ProcessingTime(5.seconds))
    .start
  q.awaitTermination
}
