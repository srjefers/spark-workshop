organization := "pl.japila.spark"
name         := "spark-workshop"
version      := "1.0.0"

scalaVersion := "2.11.8"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

val sparkV = "2.1.0"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core"      % sparkV,
  "org.apache.spark" %% "spark-sql"       % sparkV,
  "org.apache.spark" %% "spark-hive"      % sparkV,
  "org.apache.spark" %% "spark-streaming" % sparkV,
  "org.apache.spark" %% "spark-mllib"     % sparkV
)

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

val scalatestV = "3.0.0-RC4"
libraryDependencies += "org.scalactic" %% "scalactic" % scalatestV
libraryDependencies += "org.scalatest" %% "scalatest" % scalatestV % "test"
