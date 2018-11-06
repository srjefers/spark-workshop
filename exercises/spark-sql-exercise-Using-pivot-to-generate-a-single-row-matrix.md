# Exercise: Using pivot to generate a single-row matrix (Spark SQL)

Pivot a two-column dataframe to one-row one (long to wide).

## Input Dataset

```text
+--------+-----+
|   udate|   cc|
+--------+-----+
|20090622|  458|
|20090624|31068|
|20090626|  151|
|20090629|  148|
|20090914|  453|
+--------+-----+
```

## Expected Dataset

```text
+-----+--------+--------+--------+--------+--------+
|udate|20090622|20090624|20090626|20090629|20090914|
+-----+--------+--------+--------+--------+--------+
|   cc|     458|   31068|     151|     148|     453|
+-----+--------+--------+--------+--------+--------+
```

Duration: **30 mins**

<!--
https://stackoverflow.com/q/40370890/1305344
## Solution

```text
val solution = d.groupBy().pivot("udate").agg(first("cc"))
val betterSolution = solution.select(lit("cc") as "udate", $"*")
```

-->
