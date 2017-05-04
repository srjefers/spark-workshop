name := "spark-streaming-kafka-direct"
organization := "pl.jaceklaskowski.spark"
version := "1.0"

scalaVersion := "2.11.11"

val sparkV = "2.1.1"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka-0-10" % sparkV
libraryDependencies += "org.apache.spark" %% "spark-streaming" % sparkV
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkV
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkV
