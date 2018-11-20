# Exercise: Difference in Days Between Dates As Strings

Use `spark-shell` to write a structured query that calculates the number of days between date strings and the current day.

Protip™: Use the standard functions for date and time, e.g. `to_date` and `datediff`

Module: **Spark SQL**

Duration: **30 mins**

## Input Dataset

```text
val dates = Seq(
   "08/11/2015",
   "09/11/2015",
   "09/12/2015").toDF("date_string")

scala> dates.show
+-----------+
|date_string|
+-----------+
| 08/11/2015|
| 09/11/2015|
| 09/12/2015|
+-----------+
```

## Result

```text
+-----------+----------+----+
|date_string|   to_date|diff|
+-----------+----------+----+
| 08/11/2015|2015-11-08|1108|
| 09/11/2015|2015-11-09|1107|
| 09/12/2015|2015-12-09|1077|
+-----------+----------+----+
```

## Useful Links

1. Scaladoc of the [functions](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$) object

<!--
## Solution

```text
val solution = dates
   .withColumn("to_date", to_date('date_string, "dd/MM/yyyy"))
   .withColumn("diff", datediff(current_date, 'to_date))
```

-->
