import java.util.concurrent.Executors

import org.apache.log4j.{Level, LogManager}
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Utils {
  def concatenate(v1: String, v2: String) = s"$v1 + $v2"
}

object StreamingKafkaDirectApp extends App {

  LogManager.getRootLogger.setLevel(Level.INFO)

  val spark = SparkSession.builder
    .config("spark.sql.warehouse.dir", "target/spark-warehouse")
    .getOrCreate
  val sc = spark.sparkContext
  val ssc = new StreamingContext(sc, batchDuration = Seconds(10))
  try {
    import org.apache.spark.streaming.kafka010._

    val preferredHosts = LocationStrategies.PreferConsistent
    val topics = List("topic1", "topic2", "topic3")
    import org.apache.kafka.common.serialization.StringDeserializer
    val kafkaParams = Map(
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "StreamingKafkaDirectApp",
      "auto.offset.reset" -> "earliest"
    )
    import org.apache.kafka.common.TopicPartition
    // val offsets = Map(new TopicPartition("topic3", 0) -> 2L)
    val offsets = Map.empty[TopicPartition, Long]

    import org.apache.spark.streaming.dstream.InputDStream
    import org.apache.kafka.clients.consumer.ConsumerRecord
    val dstream: InputDStream[ConsumerRecord[String, String]] =
      KafkaUtils.createDirectStream[String, String](
        ssc,
        preferredHosts,
        ConsumerStrategies.Subscribe[String, String](topics, kafkaParams, offsets))

    // NOTE: ConsumerRecord is not serializable
    // So the following won't work -- dunno why.
//    import org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER
//    dstream.persist(MEMORY_AND_DISK_SER)

    // Pipeline #1
    dstream
      .map { r => (0, r.value.toString) }
      .reduceByKeyAndWindow(
        reduceFunc = Utils.concatenate, windowDuration = Seconds(30), slideDuration = Seconds(10))
      .print()

    // Pipeline #2
    dstream.foreachRDD { rdd =>
      // Get the offset ranges in the RDD
      val offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
      for (o <- offsetRanges) {
        println(s">>> ${o.topic} ${o.partition} offsets: ${o.fromOffset} to ${o.untilOffset}")
      }
    }

    // Pipeline #3
    // Spark SQL integration
    // See http://spark.apache.org/docs/latest/streaming-programming-guide.html#dataframe-and-sql-operations
    val executorService = Executors.newFixedThreadPool(1)
    dstream.map(cr => cr.value).foreachRDD { rdd =>
      import org.apache.spark.sql._
      val spark = SparkSession.builder.config(rdd.sparkContext.getConf).getOrCreate
      import spark.implicits._
      import spark.sql

      val records = rdd.toDF("record")
      records.createOrReplaceTempView("records")

      executorService.submit {
        new Runnable {
          override def run(): Unit = {
            sql("select * from records").show(truncate = false)
          }
        }
      }
    }

    // reduceByKeyAndWindow
    // http://stackoverflow.com/q/43777143/1305344
    import org.apache.spark.streaming.dstream.DStream
    val mapped: DStream[(String, Int)] = dstream.map(_ => ("mockkey", 1))

    val add = (x: Int, y: Int) => x + y
    mapped.reduceByKeyAndWindow(add, Seconds(30), Seconds(10)).print()

    // Pipeline to read file names from records and process them using Spark
    // http://stackoverflow.com/q/44044317/1305344
    def sendMessage(message: String) = {
      println(s"Sending $message to Kafka")
    }
    dstream.map(_.value).foreachRDD { rdd =>
      println(s"Received rdd: $rdd with ${rdd.count()} records")
      // take paths from RDD that contains Kafka records with the file names
      val files = rdd.collect()
      files.foreach { f =>
        // read a file `f` using Spark Core's RDD API
        rdd.sparkContext.textFile(f).map { line =>
          // do something with line
          // this is the place for a pure Spark transformation
          // it's as if you were outside Spark Streaming
          println(line)
          line
        }.foreachPartition { linesAfterProcessingPerPartition =>
          // send lines to Kafka
          // they have been processed using Spark
          linesAfterProcessingPerPartition.foreach { line =>
            sendMessage(message = line)
          }
        }
      }
    }

    ssc.start
    ssc.awaitTermination()
  } finally {
    ssc.stop()
  }
}
