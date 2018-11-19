# Exercise: Loading Dataset In Format Of show Output Using DataFrameReader

The exercise is about loading a dataset that is in the format of `show` output using `DataFrameReader`.

In other words, given the output of `show` from a 3-column Dataset, load it using `spark.read` to create the 3-column Dataset (aka _reverse-engineer the output_).

Module: **Spark SQL**

## Input Dataset

```text
+---+------------------+-----+
|id |Text1             |Text2|
+---+------------------+-----+
|1  |one,two,three     |one  |
|2  |four,one,five     |six  |
|3  |seven,nine,one,two|eight|
|4  |two,three,five    |five |
|5  |six,five,one      |seven|
+---+------------------+-----+
```

Protips:

* `+`s are comments
* `|`s are separators
* A CSV file with `+`s as comments and `|`s as separators
* [CSVOptions.scala](https://github.com/apache/spark/blob/master/sql/catalyst/src/main/scala/org/apache/spark/sql/catalyst/csv/CSVOptions.scala)
* [CSVFileFormat](https://jaceklaskowski.gitbooks.io/mastering-spark-sql/spark-sql-CSVFileFormat.html)

## Expected Dataset

```text
+---+------------------+-----+
| id|             Text1|Text2|
+---+------------------+-----+
|  1|     one,two,three|  one|
|  2|     four,one,five|  six|
|  3|seven,nine,one,two|eight|
|  4|    two,three,five| five|
|  5|      six,five,one|seven|
+---+------------------+-----+
```

<!--

// Solution 1
val in = spark
  .read
  .textFile("input.csv")
  .filter(!($"value" startsWith "+"))
  .select(split($"value", "[|]"))
  .as[Seq[String]]
  .map(ss => ss.map(_.trim))
  .map { case Seq(_,a,b,c,_) => s"$a|$b|$c" }
scala> in.show(false)
+--------------------------+
|value                     |
+--------------------------+
|id|Text1|Text2            |
|1|one,two,three|one       |
|2|four,one,five|six       |
|3|seven,nine,one,two|eight|
|4|two,three,five|five     |
|5|six,five,one|seven      |
+--------------------------+

val s = spark
  .read
  .option("header", true)
  .option("sep", "|")
  .csv(in)
scala> s.show
+---+------------------+-----+
| id|             Text1|Text2|
+---+------------------+-----+
|  1|     one,two,three|  one|
|  2|     four,one,five|  six|
|  3|seven,nine,one,two|eight|
|  4|    two,three,five| five|
|  5|      six,five,one|seven|
+---+------------------+-----+

// Solution 2
val data = spark.read
  .textFile("exercise.txt")
  .filter(_.startsWith("|"))
  .map(_.substring(1))
  .map(_.split('|'))
val headers = data.head.map(_.trim)
def onlyNumbers(colName: String) = !(col(colName) startsWith colName)
val onlyNumbersInFirstColumn = onlyNumbers(headers.head)
val s = data
  .select(headers.indices.map(idx => 'value(idx) as headers(idx)): _*)
  .filter(onlyNumbersInFirstColumn)

// Solution 3
val rawInput = spark
  .read
  .option("comment", "+")
  .option("delimiter", "|")
  .option("header", true)
  .option("ignoreLeadingWhiteSpace", true)
  .option("ignoreTrailingWhiteSpace", true)
  .csv("exercise.txt")
val headersToDrop = rawInput.columns.filter(_ startsWith "_")
val s = rawInput.drop(headersToDrop: _*)

// Solution 4: foldLeft
// FIXME
-->
