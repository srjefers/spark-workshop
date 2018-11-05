# Exercise: Using Dataset.flatMap Operator (Spark SQL)

## Steps

1. Create a Dataset with a column of array type

    ```text
    val nums = Seq(Seq(1,2,3)).toDF("nums")

    scala> nums.show
    +---------+
    |     nums|
    +---------+
    |[1, 2, 3]|
    +---------+

    scala> nums.printSchema
    root
        |-- nums: array (nullable = true)
        |    |-- element: integer (containsNull = false)
    ```
2. Use **Dataset.flatMap** operator to expand the array column into rows (one per array element)
    * Read up [flatMap's scaladoc](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.Dataset)
3. (extra) Compare performance of **Dataset.flatMap** and **explode** standard function

## Result

```text
scala> solution.show
+-----+
|value|
+-----+
|    1|
|    2|
|    3|
+-----+
```

Duration: **30 mins**

<!--
## Solution

```text
scala> nums.flatMap(r => r.getSeq(0): Seq[Int]).show
+-----+
|value|
+-----+
|    1|
|    2|
|    3|
+-----+
```

-->
