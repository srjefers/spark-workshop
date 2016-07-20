organization := "pl.japila.spark"
name := "spark-external-cluster-manager"
version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

val scalatestV = "3.0.0-RC4"
libraryDependencies += "org.scalactic" %% "scalactic" % scalatestV
libraryDependencies += "org.scalatest" %% "scalatest" % scalatestV % "test"

resolvers += Resolver.mavenLocal
resolvers += "Spark 2.0.0" at "https://repository.apache.org/content/repositories/orgapachespark-1195/"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.0.0"
