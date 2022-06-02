# Exercise: Standalone Spark Application to Display Spark SQL Version

This exercise is about creating a standalone Spark SQL application in Scala that displays the version of Spark SQL in use.

Module: **Spark SQL**

Duration: **30 mins**

## Steps

1. In **IntelliJ IDEA** create a new Scala sbt-managed project
1. Define Spark SQL dependency in **build.sbt**
    * `libraryDependencies`
    * `"org.apache.spark" %% "spark-sql" % "3.2.1"`
1. Write the required **Spark SQL code**
    * Create a new instance of [SparkSession](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.SparkSession)
    * Use [SparkSession.version](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.SparkSession@version:String) method to know the version of Spark on which this application is running
    * `spark.version`
1. Build an executable jar
    * Use `sbt package` on command line or use IDEA's sbt view
1. Run the application using `spark-submit`
