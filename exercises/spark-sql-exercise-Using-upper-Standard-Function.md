# Exercise: Using upper Standard Function

Develop a standalone Spark SQL application (using IntelliJ IDEA) that converts a string column to upper case.

(Extra) Load a CSV data set with the path given on command line

Module: **Spark SQL**

Duration: **15 mins**

## Input Dataset

```text
+---+-----------------+
| id|             city|
+---+-----------------+
|  0|           Warsaw|
|  1|Villeneuve-Loubet|
+---+-----------------+
```

```text
id,city
0,Warsaw
1,Villeneuve-Loubet
```

## Result

```text
+---+-----------------+-----------------+
| id|             city|            upper|
+---+-----------------+-----------------+
|  0|           Warsaw|           WARSAW|
|  1|Villeneuve-Loubet|VILLENEUVE-LOUBET|
+---+-----------------+-----------------+
```

## Useful Links

1. Scaladoc of the [functions](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$) object

<!--
## Solution

```text
val solution = cities.withColumn("upper", upper('city))
```

-->
