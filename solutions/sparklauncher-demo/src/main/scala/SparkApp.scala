object SparkApp extends App {

  println("Hello from SparkApp")
  if (args.length > 0) {
    println(s"Got the following input args:")
    args.foreach { a =>
      println(s"- $a")
    }
  }
}
