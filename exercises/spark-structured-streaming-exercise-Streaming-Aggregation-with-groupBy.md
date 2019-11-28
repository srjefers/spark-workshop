# Exercise: Stateless Streaming Aggregation (Dataset.groupBy)

Develop a standalone Spark Structured Streaming application (using IntelliJ IDEA) that uses a streaming query to count the words (in files or lines processed) and prints the result out to the console.

This is an example of **stateless stream processing** in general and **stateless streaming aggregation** in particular in which a **streaming aggregation query** does aggregation over data from a single trigger (and knows nothing about the past data that may have already been processed).

In this exercise, you'll be doing the following:

* Using `socket` streaming source that reads text data from a socket connection. Use `nc` on Unix / Linux or `netcat` on MS Windows, e.g. `nc -lk 9999`

* Splitting the lines (per trigger) and [Dataset.groupBy](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.Dataset) over words to count them

In the end, use `sbt package` and `spark-submit` to run the application.

**NOTE**: The default output mode of a streaming query is `Append`. That will not work for aggregation streaming queries though. Observe what happens when you change the output mode of your streaming query to the other output modes, i.e. `Complete` and `Update`. How would you explain the behaviour?

Module: **Spark Structured Streaming**

Duration: **30 mins**

<!--
## Solution

val solution = ???
-->
