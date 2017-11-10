package pl.japila.spark

import org.apache.spark.sql.SparkSession

object FilterApp extends App {

  val n = args(0).toInt
  val nums = 1 to n

  // Problem: Given a sequence of numbers take every 2nd number

  // Scala-only Solution == One Single JVM
  nums.zipWithIndex
    .filter { case (elem, idx) => idx % 2 == 0 }
    .map { case (elem, _) => elem }
    .foreach(print)

  val spark = SparkSession.builder.getOrCreate
  import spark.implicits._

  // Solution 1: Use Spark to handle more data (than your one single JVM could handle)
  nums.zipWithIndex.toDF("n", "index")
    .filter($"index" % 2 === 0)
    .select("n")
    .collect
    .map(r => r.getInt(0))  // <-- Row-based computation
    .foreach(println)

  // Solution 2: Use Dataset API (not DataFrame API)
  nums.zipWithIndex.toDF("n", "index")
    .filter($"index" % 2 === 0)
    .select("n")
    .as[Int]  // <-- be careful, you're leaving internal world of Spark
    .collect  // <-- be careful, you're leaving Spark!!!
    .foreach(println)

}
