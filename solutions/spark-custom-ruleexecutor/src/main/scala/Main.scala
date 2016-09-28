package pl.jaceklaskowski.spark

import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.SparkPlan
import org.apache.spark.sql.{SparkSession, Strategy}

object Main extends App {

  object MyStrategy extends Strategy {
    override def apply(plan: LogicalPlan): Seq[SparkPlan] = {
      println(">>> Hello from MyStrategy...")
      Nil
    }
  }

  val spark = SparkSession.builder
    .master("local[*]")
    .getOrCreate()
  try {
    spark.experimental.extraStrategies = MyStrategy :: Nil

    val query = spark.range(0)
    query.explain(extended = true)
  } finally {
    spark.stop
  }
}
