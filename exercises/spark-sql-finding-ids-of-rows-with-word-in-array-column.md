# [Spark SQL] Finding Ids of Rows with Word in Array Column

The exercise is about finding the ids of the rows that have values from one column in an array column.

## Input Dataset

```
scala> ds.show
+---+------------------+-----+
| id|             Text1|Text2|
+---+------------------+-----+
|  1|     one,two,three|  one|
|  2|     four,one,five|  six|
|  3|seven,nine,one,two|eight|
|  4|    two,three,five| five|
|  5|      six,five,one|seven|
+---+------------------+-----+
```

## Result

```
+-----+------------+
|    w|         set|
+-----+------------+
|seven|         [3]|
|  one|[3, 1, 2, 5]|
|  six|         [5]|
| five|   [2, 5, 4]|
+-----+------------+
```

The word "seven" is in the row with the id `3`.

The word "one" is in the rows with the ids `1`, `2`, `3` and `5`.

## Solution

```
val ds = ... // the input dataset
val words = ds.withColumn("w", explode(split($"text1", ",")))
val s = words
  .join(ds.select($"text2" as "w"), Seq("w"))
  .groupBy("w")
  .agg(collect_set($"id") as "set")
scala> s.show
+-----+------------+
|    w|         set|
+-----+------------+
|seven|         [3]|
|  one|[3, 1, 2, 5]|
|  six|         [5]|
| five|   [2, 5, 4]|
+-----+------------+
```
