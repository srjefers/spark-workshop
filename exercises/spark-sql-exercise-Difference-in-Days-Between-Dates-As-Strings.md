# Exercise: Difference in Days Between Dates As Strings (Spark SQL)

## Steps

1. Given dataset with date strings calculate number of days between them and current day
2. Use **to_date** and **datediff** functions
3. Read Spark API scaladoc for [functions object](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$)

```text
val dates = Seq(
   "08/11/2015",
   "09/11/2015",
   "09/12/2015").toDF("date_string")

val diffs = // <-- your solution here

scala> diffs.show
+-----------+----------+----+
|date_string|   to_date|diff|
+-----------+----------+----+
| 08/11/2015|2015-11-08|1066|
| 09/11/2015|2015-11-09|1065|
| 09/12/2015|2015-12-09|1035|
+-----------+----------+----+
```

Duration: **30 mins**

<!--
## Solution

```text
???
```

-->
