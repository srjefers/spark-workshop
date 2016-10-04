# Spark Executor Monitor Project

The project demonstrates how to use [SparkListener](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.scheduler.SparkListener) interface to build a custom Spark listener to monitor executors being added and removed while a Spark application is running.

Package the project using `sbt package` and place the jar on the driver's class path.

```
$SPARK_HOME/bin/spark-shell \
    -c spark.extraListeners=pl.jaceklaskowski.spark.SparkExecutorListener \
    --driver-class-path target/scala-2.11/spark-listener-executor-monitor_2.11-1.0.jar \
    --master spark://japila.local:7077 \
    -c spark.dynamicAllocation.enabled=true \
    -c spark.shuffle.service.enabled=true
```

TIP: Don't start the [External Shuffle Service](https://jaceklaskowski.gitbooks.io/mastering-apache-spark/content/spark-ExternalShuffleService.html) to see executors added and removed due to their failure to connect to the service.

```
scala> sc.requestExecutors(2)
res0: Boolean = true

scala> >>> executor id=0 added on host=192.168.65.1
16/10/03 21:31:25 ERROR TaskSchedulerImpl: Lost executor 0 on 192.168.65.1: Unable to create executor due to Unable to register with external shuffle server due to : Failed to connect to /192.168.65.1:7337
>>> executor id=0 removed from host=192.168.65.1
>>> executor id=1 added on host=192.168.65.1
16/10/03 21:31:37 ERROR TaskSchedulerImpl: Lost executor 1 on 192.168.65.1: Unable to create executor due to Unable to register with external shuffle server due to : Failed to connect to /192.168.65.1:7337
>>> executor id=1 removed from host=192.168.65.1
>>> executor id=2 added on host=192.168.65.1
16/10/03 21:31:49 ERROR TaskSchedulerImpl: Lost executor 2 on 192.168.65.1: Unable to create executor due to Unable to register with external shuffle server due to : Failed to connect to /192.168.65.1:7337
>>> executor id=2 removed from host=192.168.65.1
>>> executor id=3 added on host=192.168.65.1
```