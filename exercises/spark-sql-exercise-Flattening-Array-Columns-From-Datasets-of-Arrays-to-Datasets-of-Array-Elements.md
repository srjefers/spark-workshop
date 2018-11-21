# Exercise: Flattening Array Columns (From Datasets of Arrays to Datasets of Array Elements)

Develop a standalone Spark application that creates columns with the values of elements of an array column.

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
val header = input.as[Array[Int]].head
val columns = header.indices.map(n => 'value(n) as n.toString)
val s = input.select(columns: _*)
-->
