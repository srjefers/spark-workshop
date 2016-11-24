name := "spark-mllib-custom-transformer"
organization := "pl.japila.spark"
version := "1.0"

scalaVersion := "2.11.8"

val sparkVer = "2.0.2"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % sparkVer

val scalatestVer = "3.0.1"
libraryDependencies += "org.scalactic" %% "scalactic" % scalatestVer
libraryDependencies += "org.scalatest" %% "scalatest" % scalatestVer % "test"

libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVer % "test"
