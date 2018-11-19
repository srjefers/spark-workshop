# Exercise: Standalone Spark Application to Display Spark SQL Version

The exercise is to create a standalone Spark SQL application that displays the version of Spark SQL in use.

Module: **Spark SQL**

Duration: **30 mins**

## Steps

1. Create a Scala sbt-managed standalone application
    * Use **IntelliJ IDEA**
2. Define Spark SQL dependency in **build.sbt**
    * **libraryDependencies**
    * **"org.apache.spark" %% "spark-sql" % "2.4.0"**
3. Write your **Spark SQL code**, i.e. **spark.version**
    * **SparkSession**
4. Execute **sbt package**
5. Run the application using **spark-submit**
