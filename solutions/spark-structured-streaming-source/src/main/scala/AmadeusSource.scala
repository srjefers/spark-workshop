package pl.japila.spark

import org.apache.spark.sql.execution.streaming.{LongOffset, Offset, Source}
import org.apache.spark.sql.sources.{DataSourceRegister, StreamSourceProvider}
import org.apache.spark.sql.types.{IntegerType, StructType}
import org.apache.spark.sql.{DataFrame, SQLContext}

class AmadeusSource(
    override val schema: StructType,
    sqlContext: SQLContext)
  extends Source {

  var offset = LongOffset(0)

  override def getOffset: Option[Offset] = {
    println(">>> getOffset")
    offset = offset + 1
    Some(offset)
  }

  override def getBatch(start: Option[Offset], end: Offset): DataFrame = {
    println(s">>> getBatch($start, $end)")
    val n = end.asInstanceOf[LongOffset].offset
    sqlContext.sparkSession.range(n).toDF
  }

  override def stop(): Unit = {}
}

class AmadeusDataSourceRegister
  extends StreamSourceProvider
  with DataSourceRegister {

  println("We got instantiated")

  override def shortName() = "amadeus"

  lazy val defaultSchema = new StructType().add("id", IntegerType)

  override def sourceSchema(
    sqlContext: SQLContext,
    schema: Option[StructType],
    providerName: String,
    parameters: Map[String, String]): (String, StructType) = {
    (shortName, schema.getOrElse(defaultSchema))
  }

  override def createSource(
    sqlContext: SQLContext,
    metadataPath: String,
    schema: Option[StructType],
    providerName: String,
    parameters: Map[String, String]): Source = {
    new AmadeusSource(schema.getOrElse(defaultSchema), sqlContext)
  }
}
