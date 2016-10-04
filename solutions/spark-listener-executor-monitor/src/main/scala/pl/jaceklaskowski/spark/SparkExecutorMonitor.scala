package pl.jaceklaskowski.spark

import org.apache.spark.scheduler.{SparkListener, SparkListenerExecutorAdded, SparkListenerExecutorRemoved}

class SparkExecutorMonitor extends SparkListener {

  type ExecutorId = String
  type ExecutorHost = String

  var executors = collection.mutable.HashMap.empty[ExecutorId, ExecutorHost]

  override def onExecutorAdded(executorAdded: SparkListenerExecutorAdded): Unit = {
    val execId = executorAdded.executorId
    val host = executorAdded.executorInfo.executorHost
    executors += (execId -> host)
    println(s">>> executor id=$execId added on host=$host")
  }

  override def onExecutorRemoved(executorRemoved: SparkListenerExecutorRemoved): Unit = {
    val execId = executorRemoved.executorId
    val host = executors remove execId getOrElse "Host unknown"
    println(s">>> executor id=$execId removed from host=$host")
  }
}
