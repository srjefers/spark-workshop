# Exercise: Finding maximum value (agg)

Develop a standalone Spark SQL application (using IntelliJ IDEA) that finds the biggest city (among the cities in a dataset).

Protip™: Use standard functions (not UDFs!)

Module: **Spark SQL**

Duration: **20 mins**

## Input Dataset

```text
+---+-----------------+----------+
| id|             name|population|
+---+-----------------+----------+
|  0|           Warsaw| 1 764 615|
|  1|Villeneuve-Loubet|    15 020|
+---+-----------------+----------+
```

```text
id,name,population
0,Warsaw,1 764 615
1,Villeneuve-Loubet,15 020
```

## Result

```text
+--------------+
|max_population|
+--------------+
|       1764615|
+--------------+
```

## Useful Links

1. Scaladoc of the [functions](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$) object

<!--
## Solution

```text
val cities = spark.read.option("header", true).csv("cities.csv")

val solution1 = cities
  .withColumn("pop", translate($"population", " ", "") cast "long")
  .agg(max('pop) as "population")

val solution2 = cities.withColumn("pop", regexp_replace('population, " ", "").as[Int]).agg(max('pop))

val solution3 = cities.withColumn("pop", regexp_replace('population, "\\s+", "").as[Int]).agg(max('pop))
```

-->
