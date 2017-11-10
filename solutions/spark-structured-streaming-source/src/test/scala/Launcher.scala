// Launch the main application
// Run as follows:
//
// sbt sparkStructuredStreamingSource/test:run
//
// The trick is to build a SparkSession with pre-defined local[*] master URL
// so when Main is executed the one and only SparkSession is already available
object Launcher extends App {
  import org.apache.spark.sql.SparkSession
  SparkSession.builder.master("local[*]").getOrCreate

  import pl.japila.spark._
  Main.main(Array.empty)
}
