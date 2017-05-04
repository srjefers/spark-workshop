# Spark Streaming Kafka 0.10 Direct

The example complements my [Spark Streaming Notes](https://jaceklaskowski.gitbooks.io/spark-streaming/spark-streaming-kafka-KafkaUtils.html) about Kafka 0.10 Direct API support in Spark Streaming 2 with Kafka as the data source.

## Running Example

```
// Terminal 1
// Start Zookeeper.
./bin/zookeeper-server-start.sh config/zookeeper.properties
```

```
// Terminal 2
// Start a Kafka server
./bin/kafka-server-start.sh config/server.properties
```

```
// Terminal 3
$ sbt package

// Use whatever Spark directory you chose at installation
$ ~/dev/oss/spark/bin/spark-submit --packages org.apache.spark:spark-streaming-kafka-0-10_2.11:2.1.1 target/scala-2.11/spark-streaming-kafka-direct_2.11-1.0.jar
```

```
// Terminal 4
// Start publishing records (strings) to topic1

$ ./bin/kafka-console-producer.sh --topic topic1 --broker-list localhost:9092
```

Monitor the streaming application in the Spark UI at [http://localhost:4040/streaming/](http://localhost:4040/streaming).

