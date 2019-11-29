# Exercise: Writing Selected Columns to Kafka

Develop a standalone Spark Structured Streaming application (using IntelliJ IDEA) that writes selected columns to a Kafka topic.

* Use `csv` data source as the streaming source and CVS files with multiple columns (e.g. `id` and `name`)
* Use `kafka` data source as the streaming sink
* "Pack" the selected columns together using [struct](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$) and [to_json](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$) standard functions

Finally, `sbt package` the application and `spark-submit` it.

Module: **Spark Structured Streaming**

Duration: **30 mins**

## Credits

* [How to write selected columns to Kafka topic?](https://stackoverflow.com/q/59036228/1305344)

<!--
## Solution

```scala
```
-->
