# Spark Structured Streaming (Apache Spark 2.2) Workshop

[Spark Structured Streaming](https://jaceklaskowski.gitbooks.io/spark-structured-streaming) is the stream processing module in Apache Spark that offers a high-level declarative streaming Dataset API built on top of Spark SQL and allowing for continuous incremental execution of structured queries. As of Spark 2.2.0, Structured Streaming has been marked stable and announced as ready for production use.

In this condensed 1-day Spark Structured Streaming hands-on workshop, you will deep dive into and develop end-to-end continuous streaming applications using Spark Structured Streaming, and in particular:

* Develop and execute your own streaming applications
* Explore available streaming sources and sinks
* Use Apache Kafka as a data source and sink
* Understand output modes
* Learn how to monitor streaming queries
* Use web UI
* Use dropDuplicates operator  for streaming deduplication (with state)
* Explain streaming query plans
* Apply groupBy and groupByKey operators for streaming aggregations
* Use window function for aggregation
* Use event time streaming watermark to handle late events
* Use flatMapGroupsWithState operator for arbitrary stateful streaming aggregation (with explicit state logic)

The programming language of the workshop is Scala (but Python or Java are acceptable yet pose mental challenge for the trainer).

The version of Apache Spark is 2.2.0 (or later when released).

## Prerequisities / Recommended Background

After completing the workshop participants should be able to:

* Experience with the basic concepts of Scala language (or Java or Python)
* Familiarity with Spark SQL concepts like DataFrame and Dataset
* Familiarity using the command line and spark-shell in particular

## Duration

1 days
