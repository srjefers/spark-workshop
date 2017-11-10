organization := "pl.japila.spark"
name := "spark-demo"
version := "1.0"

scalaVersion := "2.11.12"

val sparkVersion = "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-mllib" % sparkVersion
