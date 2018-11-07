# Exercise: Calculating Running Total / Cumulative Sum (Spark SQL)

The exercise is to calculate [running total](https://en.wikipedia.org/wiki/Running_total) (aka **cumulative sum** or **partial sum**) over time per department.

From [Wikipedia](https://en.wikipedia.org/wiki/Running_total):

> A **running total** is the summation of a sequence of numbers which is updated each time a new number is added to the sequence, by adding the value of the new number to the previous running total.

## Input Dataset

```text
time,department,items_sold
1,IT,15
2,Support,81
3,Support,90
4,Support,25
5,IT,40
6,IT,24
7,Support,31
8,Support,1
9,HR,27
10,IT,75
```

```text
scala> sales.show
+----+----------+----------+
|time|department|items_sold|
+----+----------+----------+
|   1|        IT|        15|
|   2|   Support|        81|
|   3|   Support|        90|
|   4|   Support|        25|
|   5|        IT|        40|
|   6|        IT|        24|
|   7|   Support|        31|
|   8|   Support|         1|
|   9|        HR|        27|
|  10|        IT|        75|
+----+----------+----------+
```

NOTE: Use [Online Generate Test Data](http://www.convertcsv.com/generate-test-data.htm) for more sophisticated datasets in CSV or JSON format.

## Expected Dataset

```text
+----+----------+----------+-------------+
|time|department|items_sold|running_total|
+----+----------+----------+-------------+
|   9|        HR|        27|           27|
|   1|        IT|        15|           15|
|   5|        IT|        40|           55|
|   6|        IT|        24|           79|
|  10|        IT|        75|          154|
|   2|   Support|        81|           81|
|   3|   Support|        90|          171|
|   4|   Support|        25|          196|
|   7|   Support|        31|          227|
|   8|   Support|         1|          228|
+----+----------+----------+-------------+
```

Duration: **30 mins**

<!--
## Solution

```text
// Mind the inferSchema so time is a numeric value
val sales = spark.read.option("header", true).option("inferSchema", true).csv("sales.csv")

import org.apache.spark.sql.expressions.Window
val departmentByTimeAsc = Window.partitionBy("department").orderBy($"time".asc)

val solution = sales.withColumn("running_total", sum('items_sold) over departmentByTimeAsc)
```

-->
