# Exercise: Multiple Aggregations

Use `spark-shell` to compute maximum and minimum of `id` column for every group.

Module: **Spark SQL**

Duration: **15 mins**

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
+-----+------+------+
|group|max_id|min_id|
+-----+------+------+
|    0|     4|     0|
|    1|     3|     1|
+-----+------+------+
```

<!--
## Solution

```text
val solution = nums.groupBy("group").agg(max('id) as "max_id", min('id) as "min_id")
```

-->
