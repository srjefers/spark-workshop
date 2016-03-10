organization := "pl.japila"
name         := "spark-workshop"
version      := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.6"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

val sparkV = "1.6.1"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core"      % sparkV % "provided",
  "org.apache.spark" %% "spark-sql"       % sparkV % "provided",
  "org.apache.spark" %% "spark-hive"      % sparkV % "provided",
  "org.apache.spark" %% "spark-streaming" % sparkV % "provided",
  "org.apache.spark" %% "spark-mllib"     % sparkV % "provided"
)
libraryDependencies += "com.databricks" %% "spark-csv" % "1.4.0"

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0-M15" % "test"
