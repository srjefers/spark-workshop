# Exploding structs array

Write a structured query that "explodes" an array of structs (of open and close hours).

Module: **Spark SQL**

Duration: **30 mins**

## Input Dataset

```text
$ cat input.json
{
  "business_id": "abc",
  "full_address": "random_address",
  "hours": {
    "Monday": {
      "close": "02:00",
      "open": "11:00"
    },
    "Tuesday": {
      "close": "02:00",
      "open": "11:00"
    },
    "Friday": {
      "close": "02:00",
      "open": "11:00"
    },
    "Wednesday": {
      "close": "02:00",
      "open": "11:00"
    },
    "Thursday": {
      "close": "02:00",
      "open": "11:00"
    },
    "Sunday": {
      "close": "00:00",
      "open": "11:00"
    },
    "Saturday": {
      "close": "02:00",
      "open": "11:00"
    }
  }
}
```

```text
scala> input.show(truncate = false)
+-----------+--------------+----------------------------------------------------------------------------------------------------------------+
|business_id|full_address  |hours                                                                                                           |
+-----------+--------------+----------------------------------------------------------------------------------------------------------------+
|abc        |random_address|[[02:00, 11:00], [02:00, 11:00], [02:00, 11:00], [00:00, 11:00], [02:00, 11:00], [02:00, 11:00], [02:00, 11:00]]|
+-----------+--------------+----------------------------------------------------------------------------------------------------------------+
```

## Result

```text
scala> solution.show(truncate = false)
+-----------+--------------+---------+---------+----------+
|business_id|full_address  |day      |open_time|close_time|
+-----------+--------------+---------+---------+----------+
|abc        |random_address|Friday   |11:00    |02:00     |
|abc        |random_address|Monday   |11:00    |02:00     |
|abc        |random_address|Saturday |11:00    |02:00     |
|abc        |random_address|Sunday   |11:00    |00:00     |
|abc        |random_address|Thursday |11:00    |02:00     |
|abc        |random_address|Tuesday  |11:00    |02:00     |
|abc        |random_address|Wednesday|11:00    |02:00     |
+-----------+--------------+---------+---------+----------+
```

<!--
## Credits

* [How to explode structs array?](https://stackoverflow.com/q/53870797/1305344)

## Solution

```text
// http://spark.apache.org/docs/latest/api/scala/org/apache/spark/sql/DataFrameReader.html for options
val input = spark.read.option("multiLine", true).json("input.json")

// query for day names
import org.apache.spark.sql.types.StructType
val days = input
  .schema 
  .fields
  .filter(_.name == "hours")
  .head
  .dataType
  .asInstanceOf[StructType]
  .fieldNames

val solution = input
  .select(
    $"business_id",
    $"full_address",
    explode(
      array(
        days.map(d => struct(
          lit(d).as("day"),
          col(s"hours.$d.open").as("open_time"),
          col(s"hours.$d.close").as("close_time")
        )): _*
      )
    )
  )
  .select($"business_id", $"full_address", $"col.*")
```
-->
