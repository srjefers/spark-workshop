# Exercise: Basic Streaming Aggregation

Develop a standalone Spark Structured Streaming application (using IntelliJ IDEA) that runs a streaming query that counts the words and prints the result out to the console.

It is an example of **stateless stream processing** in which a **streaming aggregation query** does aggregation over data from a single trigger (and knows nothing about the past data that may have already been processed).

The query should use `csv` streaming data source and `console` streaming sink. The query should split the lines from CSV files (per trigger) and `groupBy` over words to count them.

In the end, use `sbt package` and `spark-submit` to run the application.

(Extra) By default, a streaming query uses `Append` output mode. Observe what happens when you change the output mode of your streaming query to the other output modes, i.e. `Complete` and `Update`.

Module: **Spark Structured Streaming**

Duration: **30 mins**

<!--
## Solution

val solution = ???
-->
