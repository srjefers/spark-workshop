name := "spark-workshop-solutions"

lazy val commonSettings = Seq(
  organization := "pl.japila.spark",
  version := "1.0.0",
  scalaVersion := "2.11.12",

  libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.2"
)


lazy val sparkStructuredStreamingSource = (project in file("spark-structured-streaming-source"))
  .settings(commonSettings)
