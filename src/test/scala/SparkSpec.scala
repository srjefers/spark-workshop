package pl.japila

import org.apache.spark.{SparkContext, SparkConf}
import org.scalatest.FlatSpec

class SparkSpec extends FlatSpec {

  "Spark" should "start" in {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("MoveSpec")
    val sc = new SparkContext(conf)

    val longs = sc.range(0, 10).collect()
    assert(longs.size === 10)

    sc.stop()
  }
}
