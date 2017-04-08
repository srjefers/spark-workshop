import java.io.{BufferedReader, InputStreamReader}

import org.apache.spark.launcher.SparkLauncher

object SparkLauncherApp extends App {

  val launcher = new SparkLauncher()
    .setSparkHome("/Users/jacek/dev/oss/spark")
    //.setAppResource(SparkLauncher.NO_RESOURCE)
    .setAppResource("target/scala-2.11/classes")
    .redirectError()
    .setMainClass("SparkApp")
    .addAppArgs("hello", "world")

  //  launcher.addSparkArg("--help")

  val app = launcher.launch()
  // subprocess' output -> this process output
  val reader = new BufferedReader(new InputStreamReader(app.getInputStream))
  reader.lines().toArray.foreach(println)
  app.waitFor()

  println(s"App id: ${app.exitValue()}")
}
