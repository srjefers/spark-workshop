# Exercise: Flattening Array Columns (From Datasets of Arrays to Datasets of Array Elements)

Module: Spark SQL

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

## Expected Dataset

```text
scala> s.show
+---+---+---+
|  0|  1|  2|
+---+---+---+
|  1|  2|  3|
+---+---+---+
```

Duration: **30 mins**

<!--
val header = input.as[Array[Int]].head
val columns = header.indices.map(n => 'value(n) as n.toString)
val s = input.select(columns: _*)
-->
