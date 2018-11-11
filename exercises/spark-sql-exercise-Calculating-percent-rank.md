# Exercise: Calculating percent rank

A dataset has employees and salaries entries in no particular order. Add a new column per the following requirements:

1. Top 30% gets a value "high"
2. The next 40% gets "average"
3. The rest gets "low"

Based on [How to add a column with values based on popularity?](https://stackoverflow.com/q/47195372/1305344)

Module: Spark SQL

## Input Dataset

```text
Employee  Salary
Tony      50
Alan      45
Lee       60
David     35
Steve     65
Paul      48
Micky     62
George    80
Nigel     64
John      42
```

## Expected Dataset

```text
Employee   Salary  Percentage
Tony       50      Average
Alan       45      Low
Lee        60      Average
David      35      Low
Steve      65      High
Paul       48      Average
Micky      62      Average
George     80      High
Nigel      64      High
John       42      Low
```

Duration: **30 mins**

## Protips

1. Use window aggregation
2. Use [percent_rank](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$) function
    * Window function that returns the relative rank (percentile) of rows within a window partition.
3. Use [when](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.Column) and [otherwise](http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.Column) methods for the labels
    * **when** evaluates a list of conditions and returns one of multiple possible result expressions
    * **otherwise** gives the value when no **when**s have matched

<!--
## Solution

val solution = ???
-->
