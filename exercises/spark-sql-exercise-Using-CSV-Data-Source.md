# Exercise: Using CSV Data Source

The exercise is about creating a standalone Spark SQL application that loads CSV file and prints the content out to the console.

Module: **Spark SQL**

Duration: **30 mins**

## Steps

1. Write Spark SQL code
    * `spark.read.csv`
    * Use `header` and `inferSchema` options
    * Use `args` for the path to CSV file(s)
    * `show` the records
1. Build an executable jar using `sbt package`
1. Run the application using `spark-submit`
