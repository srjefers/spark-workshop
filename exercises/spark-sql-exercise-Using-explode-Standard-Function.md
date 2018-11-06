# Exercise: Using explode Standard Function (Spark SQL)

## Steps

1. Create a Dataset with a column of array type
    ```text
    val nums = Seq(Seq(1,2,3)).toDF("nums")
    scala> nums.printSchema
    root
        |-- nums: array (nullable = true)
        |    |-- element: integer (containsNull = false)
    ```
2. Use **explode** function to expand the array column
3. (extra) Compare performance of **explode** to **flatMap**

Duration: **30 mins**

<!--
## Solution

```text
???
```

-->
