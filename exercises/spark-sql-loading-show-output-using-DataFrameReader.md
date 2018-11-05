# Exercise: Loading Dataset In Format Of show Output Using DataFrameReader (Spark SQL)

The exercise is about loading a dataset that is in the format of `show` output using `DataFrameReader`.

In other words, given the output of `show` from a 3-column Dataset, load it using `spark.read` to create the 3-column Dataset (aka _reverse-engineer the output_).

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

<!--
## Solution

```text
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

val solution = spark
  .read
  .option("header", true)
  .option("sep", "|")
  .csv(in)
scala> solution.show
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

-->
