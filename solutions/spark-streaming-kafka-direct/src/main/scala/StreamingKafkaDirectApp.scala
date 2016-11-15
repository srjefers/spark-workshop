import org.apache.log4j.{Level, LogManager}
import org.apache.spark.SparkContext
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingKafkaDirectApp extends App {

  LogManager.getRootLogger.setLevel(Level.INFO)

  val sc = SparkContext.getOrCreate
  val ssc = new StreamingContext(sc, Seconds(10))
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

    val dstream = KafkaUtils.createDirectStream[String, String](
      ssc,
      preferredHosts,
      ConsumerStrategies.Subscribe[String, String](topics, kafkaParams, offsets))

    def reduceFunc(v1: String, v2: String) = s"$v1 + $v2"
    dstream.map { r =>
      println(s"value: ${r.value}")
      val Array(key, value) = r.value.split("\\s+")
      println(s">>> key = $key")
      println(s">>> value = $value")
      (key, value)
    }.reduceByKeyAndWindow(
      reduceFunc, windowDuration = Seconds(30), slideDuration = Seconds(10))
      .print()

    dstream.foreachRDD { rdd =>
      // Get the offset ranges in the RDD
      val offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
      for (o <- offsetRanges) {
        println(s"${o.topic} ${o.partition} offsets: ${o.fromOffset} to ${o.untilOffset}")
      }
    }

    ssc.start
    ssc.awaitTermination()

  } finally {
    ssc.stop()
  }
}
