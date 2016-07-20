import org.apache.spark._
import org.scalatest._

class ScalaniaClusterManagerSpec extends FlatSpec with Matchers {

  "Spark" should "load scalania cluster manager" in {
    val conf = new SparkConf()
      .setMaster("scalania")
      .setAppName("scalania External Cluster Manager")
    val sc = SparkContext.getOrCreate(conf)
    println(s"Custom external cluster manager: ${sc.master}")
    sc.stop
  }
}
