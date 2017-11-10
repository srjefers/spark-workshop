package pl.japila.spark

object JobGroupDemo extends App {

  import org.apache.spark.SparkContext
  val sc = new SparkContext()

  println(s"Spark version: ${sc.version}")

  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  Future {
    (0 to 9).par.
      foreach { _ =>
        sc.setJobGroup("g1", "Thanks Lea and Fadwa")
        sc.parallelize(Seq(1)).map(_ =>
          Thread.sleep(10 * 1000)).count
      }
  }
  sc.cancelJobGroup("g1")

}
