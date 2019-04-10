# Exercise: Flattening Array Columns (From Datasets of Arrays to Datasets of Array Elements)

Develop a standalone Spark SQL application (using IntelliJ IDEA) that creates columns with the values of elements of an array column.

Protips™:

1. (intermediate) Assume that the number of elements of all arrays is the same

1. (advanced) Consider [pivot](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.RelationalGroupedDataset) operator

Module: **Spark SQL**

Duration: **30 mins**

## Input Dataset

```text
val input = Seq(Seq(1,2,3)).toDF
scala> input.show
+---------+
|    value|
+---------+
|[1, 2, 3]|
+---------+

scala> input.printSchema
root
 |-- value: array (nullable = true)
 |    |-- element: integer (containsNull = false)
```

## Result

```text
+---+---+---+
|  0|  1|  2|
+---+---+---+
|  1|  2|  3|
+---+---+---+
```

<!--
// The solution assumes that the number of elements is the same across arrays
val header = input.as[Array[Int]].head
val columns = header.indices.map(n => 'value(n) as n.toString)
val s = input.select(columns: _*)

// The solution uses groupBy so it introduces a shuffle
// pivot needs values or it does full scan
// Possible case for Adaptive Query Execution
val psd = input.select(posexplode('value))
// Note the values specified explicitly
val s = psd.groupBy().pivot('pos, Array(0,1,2)).agg(first('col))

-->
