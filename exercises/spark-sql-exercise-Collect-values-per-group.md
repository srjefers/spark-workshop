# Exercise: Collect values per group

Use `spark-shell` to collect ids per group in a dataset.

Module: **Spark SQL**

Duration: **20 mins**

## Input Dataset

```text
val nums = spark.range(5).withColumn("group", 'id % 2)
scala> nums.show
+---+-----+
| id|group|
+---+-----+
|  0|    0|
|  1|    1|
|  2|    0|
|  3|    1|
|  4|    0|
+---+-----+
```

## Result

```text
+-----+---------+
|group|      ids|
+-----+---------+
|    0|[0, 2, 4]|
|    1|   [1, 3]|
+-----+---------+
```

<!--
## Solution

```text
val solution = nums.groupBy("group").agg(collect_list('id) as "ids")
```

-->
