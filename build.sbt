organization := "pl.japila.spark"
name         := "spark-workshop"
version      := "1.0.0"

scalaVersion := "2.10.6"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

val sparkV = "1.6.2"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core"      % sparkV % "provided",
  "org.apache.spark" %% "spark-sql"       % sparkV % "provided",
  "org.apache.spark" %% "spark-hive"      % sparkV % "provided",
  "org.apache.spark" %% "spark-streaming" % sparkV % "provided",
  "org.apache.spark" %% "spark-mllib"     % sparkV % "provided"
)
libraryDependencies += "com.databricks" %% "spark-csv" % "1.4.0"

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

val scalatestV = "3.0.0-RC3"
libraryDependencies += "org.scalactic" %% "scalactic" % scalatestV
libraryDependencies += "org.scalatest" %% "scalatest" % scalatestV % "test"
