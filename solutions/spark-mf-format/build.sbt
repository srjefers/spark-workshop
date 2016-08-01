organization := "pl.japila.spark"
name := "spark-mf-format"
version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

val scalatestV = "3.0.0-RC4"
libraryDependencies += "org.scalactic" %% "scalactic" % scalatestV
libraryDependencies += "org.scalatest" %% "scalatest" % scalatestV % "test"

spName := s"japila/spark-mf-format"
sparkVersion := "2.0.0"
sparkComponents += "sql"
spAppendScalaVersion := true
