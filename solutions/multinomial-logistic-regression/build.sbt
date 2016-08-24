organization := "pl.jaceklaskowski.spark"
name := "multinomial-logistic-regression"
version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.1.0-SNAPSHOT"

resolvers += Resolver.mavenLocal
resolvers += "Spark Snapshots" at "http://repository.apache.org/snapshots"
    
