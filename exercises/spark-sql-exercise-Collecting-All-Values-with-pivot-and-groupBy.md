# Exercise: Collecting All Values with pivot and groupBy

Module: **Spark SQL**

The exercise calculates cost average ([part 1](#part-1-expected-dataset)) and collects all the values in a column ([part 2](#part-2-expected-dataset)).

Duration: **30 mins**

## Input Dataset

```text
+---+----+----+------+----+
| id|type|cost|  date|ship|
+---+----+----+------+----+
|  0|   A| 223|201603|PORT|
|  0|   A|  22|201602|PORT|
|  0|   A| 422|201601|DOCK|
|  1|   B|3213|201602|DOCK|
|  1|   B|3213|201601|PORT|
|  2|   C|2321|201601|DOCK|
+---+----+----+------+----+
```

```scala
val data = Seq(
  (0, "A", 223,"201603", "PORT"),
  (0, "A", 22,"201602", "PORT"),
  (0, "A", 422,"201601", "DOCK"),
  (1,"B", 3213,"201602", "DOCK"),
  (1,"B", 3213,"201601", "PORT"),
  (2,"C", 2321,"201601", "DOCK")
).toDF("id","type", "cost", "date", "ship")
```

## Part 1. Expected Dataset

```text
+---+----+------+------+------+
| id|type|201601|201602|201603|
+---+----+------+------+------+
|  2|   C|2321.0|  null|  null|
|  1|   B|3213.0|3213.0|  null|
|  0|   A| 422.0|  22.0| 223.0|
+---+----+------+------+------+
```

<!--
data.groupBy("id", "type").pivot("date").agg(avg("cost")).show
-->

## Part 2. Expected Dataset

```text
+---+----+------+------+------+
| id|type|201601|201602|201603|
+---+----+------+------+------+
|  2|   C|[DOCK]|    []|    []|
|  1|   B|[PORT]|[DOCK]|    []|
|  0|   A|[DOCK]|[PORT]|[PORT]|
+---+----+------+------+------+
```

<!--
data.groupBy("id", "type").pivot("date").agg(collect_set("ship")).show
-->

## Hints

* Use `pivot` and `groupBy` aggregate operators with standard functions

## Credits

* Based on [How to use pivot and calculate average on a non-numeric column (facing AnalysisException "is not a numeric column")?](https://stackoverflow.com/q/37486910/1305344)
