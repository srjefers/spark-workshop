# Exercise: Finding Most Populated Cities Per Country

Write a structured query that finds the most populated cities per country.

Protip™: Use `Dataset.groupBy` operator and `max` standard function followed by `Dataset.join`.

Module: **Spark SQL**

Duration: **30 mins**

## Input Dataset

```text
+-----------------+-------+----------+
|             name|country|population|
+-----------------+-------+----------+
|           Warsaw| Poland| 1 764 615|
|           Cracow| Poland|   769 498|
|            Paris| France| 2 206 488|
|Villeneuve-Loubet| France|    15 020|
+-----------------+-------+----------+
```

```text
name,country,population
Warsaw,Poland,1 764 615
Cracow,Poland,769 498
Paris,France,2 206 488
Villeneuve-Loubet,France,15 020
```

## Result

```text
+------+-------+----------+
|  name|country|population|
+------+-------+----------+
|Warsaw| Poland| 1 764 615|
| Paris| France| 2 206 488|
+------+-------+----------+
```

<!--
## Solution

```text
val cities = spark.read.option("header", true).csv("cities.csv")
val biggestCitiesPerCountry = cities
  .withColumn("pop", translate('population, " ", "") cast "long")
  .groupBy('country).agg(max('pop) as "max_population")

val solution = biggestCitiesPerCountry
  .join(cities, Seq("country"))
  .where('max_population === translate('population, " ", "").as[Long])
  .select('name, 'country, 'population)
```

-->
