# Exercise: From and To Apache Kafka

The exercise is to use Kafka Data Source for stream processing.

Please read [KafkaSource](https://jaceklaskowski.gitbooks.io/spark-structured-streaming/content/spark-sql-streaming-KafkaSource.html) to learn about the data source and what is required to have it available in Spark Structured Streaming applications.

Module: **Spark Structured Streaming**

## Requirements

You will be using [Apache Kafka](http://kafka.apache.org/) as an external data source. Please download it first.

1. [Apache Kafka](http://kafka.apache.org/)

With Kafka installed, you should run a single-broker Kafka cluster using the following commands:

1. `./bin/zookeeper-server-start.sh config/zookeeper.properties`
2. `./bin/kafka-server-start.sh config/server.properties`

## Steps

1. Develop a standalone Spark application
    * Use IntelliJ IDEA
    * Define proper `libraryDependencies` with Spark SQL
2. (part 1) **kafka** format for source and **console** for sink
    1. Use Kafka Console Producer to send a message that Spark processes and prints out to the console
    2. `./bin/kafka-console-producer.sh --broker-list :9092 --topic input`
3. (part 2) **kafka** format for source and **kafka** for sink
    1. Use Kafka Console Consumer to consume messages that Spark processed
    2. `./bin/kafka-console-consumer.sh --topic ovh-input --bootstrap-server :9092`
4. Use **sbt package** and **spark-submit**

Duration: **45 mins**

<!--
## Solution

val solution = ???
-->
