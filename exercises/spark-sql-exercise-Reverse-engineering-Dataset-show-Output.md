# Exercise: Reverse-engineering Dataset.show Output

Write a structured query that loads a text file that contains the output of `Dataset.show` operator (aka _reverse-engineer the show output_).

There are two approaches to solve the problem with different levels of complexity. You should work it out in reverse order of complexity. _Sorry, no free lunches_ 😎

1. (hard) Use `text` data source
1. (intermediate) Use `csv` data source

Module: **Spark SQL**

Duration: **30 mins**

## Input Dataset

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

## Result

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

## Protips

* `+`s are comments
* `|`s are separators
* A CSV file with `+`s as comments and `|`s as separators
* [CSVFileFormat](https://jaceklaskowski.gitbooks.io/mastering-spark-sql/spark-sql-CSVFileFormat.html)

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
val headersToDrop = rawInput.columns.filter(_ startsWith "_c")
val s = rawInput.drop(headersToDrop: _*)

// Solution 4: foldLeft
// FIXME
-->
