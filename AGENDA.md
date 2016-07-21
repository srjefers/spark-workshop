# Spark and Scala (Application Development) Workshop

## What You Will Learn (aka Goals)

This Spark and Scala workshop is supposed to give you a practical, complete and more importantly hands-on introduction to the architecture of Apache Spark and how to use Spark's Scala API (developer) and infrastructure (administrator, devops) effectively in your Big Data projects.

**NOTE**: Should you want a workshop about administration, monitoring, troubleshooting and fine-tuning of Apache Spark, check out [Spark Administration and Monitoring Workshop](AGENDA-admin.md).

The agenda is the result of the workshops I hosted in the following cities and a few online classes:

* Toronto (3 classes)
* Mississauga
* Plymouth Meeting
* Montreal
* London

The workshop uses an intense code-first approach in which the modules start with just enough knowledge to get you going (mostly using scaladoc and live coding) and quickly move on to applying the concepts in programming assignments. There are a lot of them.

It comes with many practical sessions that should meet (and even exceed) expectations of software developers (and perhaps administrators, operators, devops, and other technical roles like system architects or technical leads).

The workshop provides participants with practical skills to use the features of Apache Spark with Scala.

**CAUTION**: The Spark and Scala workshop is very hands-on and practical, i.e. not for faint-hearted. _Seriously!_ After 5 days your mind, eyes, and hands will all be trained to recognise the patterns where and how to use Spark and Scala in your Big Data projects.

**CAUTION** I have already trained people who expressed their concern that there were too many exercises. _Your dear drill sergeant, Jacek._

## Duration

5 days

## Target Audience

* Software developers who know Scala and want to explore the Spark space
* Software developers with programming experience in a similar general-purpose programming language (Java, Python, Ruby)
* Non-programming IT professionals like administrators, devops, system architects or technical leads to learn about Spark and Scala by their APIs.

## Outcomes

After completing the workshop participants should be able to:

* Use functional programming concepts in Scala
* Describe Spark and the use cases for Apache Spark
* Explain the RDD distributed data abstraction
* Explore large datasets using interactive Spark Shell
* Develop Spark applications using Scala API
* Assemble and submit Spark applications to Spark clusters
* Use Spark in local mode as well as Spark Standalone clusters
* Install Spark development and runtime environments
* Understand the concepts of Spark SQL (DataFrame, Dataset, UDF)
* Understand the concepts of Spark Streaming (DStream, ReceiverInputDStream)
* Understand the concepts of Spark MLlib (Pipeline API)
* Understand the concepts of Spark GraphX (RDD-based Graph API)
* Build processing pipelines using Spark's RDD and abstractions above in Spark SQL (DataFrame), Spark Streaming (DStream), and Spark MLlib (Pipeline API).
* Explain the internals of Spark and execution model

## Agenda

The programming language to use during the course is [Scala](http://www.scala-lang.org/). There is a one-day "crash course" to the language during the workshop. It is optional for skilled Scala developers who are familiar with the fundamentals of Scala and sbt.

### Scala (one-day crash course)

This module aims at introducing Scala and the tools, i.e. **sbt** and **Scala REPL**, to complete the other Spark modules.

This module requires Internet access to download sbt and plugins (unless you `git clone` the repository - see [README](README.md)).

This module covers:

* Scala REPL
* Literals and Values
* Basic Types (Numerics, Strings)
* Type System
* Imports
* More Advanced Types (Tuples, Options)
  * Parameterized Types
* Expressions and Conditions
* Methods, Functions (and Procedures)
  * Using placeholders (`_`) in functions
* Scala Collection API and Common Collection Types
  * Seqs, Lists, Sets, Maps
  * The scaladoc of [scala.collection.Seq](http://www.scala-lang.org/api/current/index.html#scala.collection.Seq)
  * `filter`, `map`, `flatMap`, `zipWithIndex`, `count`
* Implicits and Multiple Parameter Lists
  * Understanding method signatures
* Case Classes, Objects, and Traits
* Command-line Applications
* Packages
* Pattern Matching
* Partial Functions
  * Using `case` to destructure input parameters
  * [Seq.collect][1]
* sbt - the build tool for Scala projects

[1]: http://www.scala-lang.org/api/current/index.html#scala.collection.Seq@collect[B](pf:PartialFunction[A,B]):Seq[B]

Agenda:

1. Using sbt
  1. The tasks: `help`, `compile`, `test`, `package`, `update`, `~`, `set`, `show`, `console`
  1. Tab experience
  1. Configuration files and directories, i.e. `build.sbt` file and `project` directory
1. Adding new tasks to sbt through plugins
  1. Global vs project plugins
  1. [sbt-assembly](https://github.com/sbt/sbt-assembly)
  1. [sbt-updates](https://github.com/rtimush/sbt-updates)
1. Using sbt behind a proxy server
  1. [HTTP/HTTPS/FTP Proxy](http://www.scala-sbt.org/0.13/docs/Setup-Notes.html#HTTP%2FHTTPS%2FFTP+Proxy) in the official documentation.
  1. [How to use sbt from behind proxy?](http://stackoverflow.com/q/13803459/1305344) on StackOverflow
1. Proxy Repositories for sbt
  1. [Proxy Repositories](http://www.scala-sbt.org/0.13/docs/Proxy-Repositories.html) in the official documentation.

### Spark SQL

1. DataFrames
  1. Exercise: Creating DataFrames
      * Seqs and `toDF`
      * `SQLContext.createDataFrame` and Explicit Schema using `StructType`
1. DataFrames and Query DSL
  1. Column References: `col`, `$`, `'`, `dfName`
  1. Exercise: Using Query DSL to `select` columns
      * `where`
1. User-Defined Functions (UDFs)
  1. functions object
  1. Exercise: Manipulating DataFrames using functions
    * `withColumn`
    * UDFs: `split` and `explode`
  1. Creating new UDFs
1. DataFrameWriter and DataFrameReader
  1. `SQLContext.read` and `load`
  1. `DataFrame.write` and `save`
  1. Exercise: WordCount using DataFrames (words per line)
      * `SQLContext.read.text`
      * `SQLContext.read.format("text")`
  1. Exercise: Manipulating data from CSV using DataFrames
      * `spark-submit --packages com.databricks:spark-csv_2.10:1.4.0`
      * `SQLContext.read.csv` vs `SQLContext.read.format("csv")` or `format("com.databricks.spark.csv")`
      * `count`
      * [CSV Data Source for Spark](https://github.com/databricks/spark-csv)
1. Aggregating
  1. Exercise: Using `groupBy` and `agg`
  1. Exercise: WordCount using DataFrames (words per file)
1. Windowed Aggregates (Windows)
  1. Exercise: Top N per Group
  1. Exercise: Revenue Difference per Category
  1. Exercise: Running Totals
1. Datasets
  1. Exercise: WordCount using `SQLContext.read.text`
  1. Exercise: Compute Aggregates using `mapGroups`
    * Word Count using Datasets
1. Caching
  1. Exercise: Measuring Query Times using web UI
1. Accessing Structured Data using JDBC
  1. Modern / New-Age Approach
  1. Exercise: Reading Data from and Writing to PostgreSQL
    * [Creating DataFrames from Tables using JDBC and PostgreSQL](https://jaceklaskowski.gitbooks.io/mastering-apache-spark/content/exercises/spark-exercise-dataframe-jdbc-postgresql.html)
1. Integration with Hive
  1. Queries over DataFrames
    * `sql`
  1. Registering UDFs
  1. Temporary and permanent tables
    * `registerTempTable`
    * `DataFrame.write` and `saveAsTable`
1. DataFrame performance optimizations
  1. Tungsten
  1. Catalyst

### Spark MLlib

1. Spark MLlib vs Spark ML
  1. (old-fashioned) RDD-based API vs (the latest and gratest) DataFrame-based API
1. Transformers
  1. Exercise: Using Tokenizer, RegexTokenizer, and HashingTF
1. Estimators and Models
  1. Exercise: Using KMeans
    * Fitting a model and checking spams
  1. Exercise: Using LogisticRegression
    * Fitting a model and checking spams
1. Pipelines
  1. Exercise: Using Pipelines of Transformers and Estimators

### Spark Streaming

1. Spark Streaming
  1. Exercise: ConstantInputDStream in motion in Standalone Streaming Application
1. Input DStreams (with and without Receivers)
  1. Exercise: Processing Files Using File Receiver
    * Word Count
  1. Exercise: Using Text Socket Receiver
  1. Exercise: Processing `vmstat` Using Apache Kafka
1. Monitoring Streaming Applications using web UI (Streaming tab)
  1. Exercise: Monitoring and Tuning Streaming Applications
    * "Sleeping on Purpose" in `map` to slow down processing
1. Spark Streaming and Checkpointing (for fault tolerance and exactly-once delivery)
  1. Exercise: Start StreamingContext from Checkpoint
1. State Management in Spark Streaming (Stateful Operators)
  1. Exercise: Use `mapWithState` for stateful computation
    * Split lines into username and message to collect messages per user
1. Spark Streaming and Windowed Operators
  1. Exercise: ???

### Spark Core

1. Spark "Installation" and Your First Spark Application (using spark-shell)
  1. [Spark API scaladoc](http://spark.apache.org/docs/latest/api/scala/index.html)
  1. Exercise: Counting Elements in Distributed Collection
      * `SparkContext.parallelize`
      * `SparkContext.range`
      * `SparkContext.textFile`
1. Using Spark’s Core APIs in Scala - Transformations and Actions
  1. Exercise: Processing lines in `README.md`
      * `filter`, `map`, `flatMap`, `foreach`
  1. Exercise: Gotchas with Transformations like `zipWithIndex` or `sortBy`
      * It may or may not submit a Spark job
      * Apply to RDDs of different number of partitions
      * Use webUI to see completed jobs
1. Using key-value pair operators
  1. Exercise: Key-value pair operators
      * `cogroup`
      * `flatMapValues`
      * `aggregateByKey`
  1. Exercise: Word Counter = Counting words in README.md
1. Building, Deploying and Monitoring Spark Applications (using sbt, spark-submit, and web UI)
  1. Exercise: A Complete Development Cycle of Spark Application
1. Processing Structured Data using RDDs
  1. Traditional / Old-Fashioned Approach
  1. Exercise: Accessing Data in CSV
1. Partitions
  1. `mapPartitionsWithIndex` and `foreachPartition`
  1. Example: FIXME
1. Accumulators
  1. Exercise: Distributed Counter
  1. Exercise: Using Accumulators and `cogroup` to Count Non-Matching Records as in `leftOuterJoin`
      * Ensure exactly-one processing despite task failures
      * Use `TaskContext` to track tasks
  1. Exercise: Custom Accumulators
      * `AccumulatorParam`
1. Broadcast Variables
1. Community Packages for Apache Spark [http://spark-packages.org](http://spark-packages.org/)
  1. Exercise: Accessing Data in Apache Cassandra using [Spark-Cassandra Connector](https://github.com/datastax/spark-cassandra-connector)
1. Submitting Spark Applications
  1. `run-example`
  1. `spark-submit`
  1. Specifying memory requirements et al.
  1. Exercise: Executing Spark Examples using `run-example`
  1. Exercise: Executing Spark Example using `spark-submit`
1. Application Log Configuration
  1. `conf/log4.properties`

### Spark GraphX

1. RDD-based Graph API
1. [GraphFrames](http://spark-packages.org/package/graphframes/graphframes): DataFrame-based Graphs
  1. `spark-shell --packages graphframes:graphframes:0.1.0-spark1.6`

### Extras

1. Exercise: Stream Processing using Spark Streaming, Spark SQL and Spark MLlib (Pipeline API).

## Requirements

* Training classes are best for groups up to 8 participants.
* Experience in software development using modern programming language (Scala, Java, Python, Ruby) is recommended. The workshop introduces Scala only enough to develop Spark applications using Scala API.
* Participants have decent computers, preferably with Linux or Mac OS operating systems
  * [There are issues with running Spark on Windows](https://jaceklaskowski.gitbooks.io/mastering-apache-spark/content/spark-tips-and-tricks-running-spark-windows.html) (mostly with Spark SQL / Hive).
* Participants have to download the following packages to their computers before the class:
  * [spark-1.6.1-bin-hadoop2.6.tgz](http://www.apache.org/dyn/closer.lua/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz)
  * [sbt-0.13.11.zip](https://dl.bintray.com/sbt/native-packages/sbt/0.13.11/sbt-0.13.11.zip)
  * [IntelliJ IDEA Community Edition 2016.1.1](https://www.jetbrains.com/idea/download/) (or equivalent development environment)
    * Install [Scala plugin](https://plugins.jetbrains.com/plugin/?id=1347)
* Optional downloads (have them ready):
  * [kafka_2.11-0.9.0.1.tgz](https://www.apache.org/dyn/closer.cgi?path=/kafka/0.9.0.1/kafka_2.11-0.9.0.1.tgz)
  * [H2 Database Engine](http://www.h2database.com/html/main.html) - download [zip file with Version 1.4.191 for All Platforms](http://www.h2database.com/h2-2016-01-21.zip)
  * [apache-cassandra-3.4-bin.tar.gz](http://www.apache.org/dyn/closer.lua/cassandra/3.4/apache-cassandra-3.4-bin.tar.gz)
  * [Cassandra Spark Connector 1.6.0-M1](http://spark-packages.org/package/datastax/spark-cassandra-connector) by executing the following command: `$SPARK_HOME/bin/spark-shell --packages datastax:spark-cassandra-connector:1.6.0-M1-s_2.10`
  * (optional) [PostgreSQL 9.5.2](http://www.postgresql.org/download/) (or later) and [JDBC42 Postgresql Driver 9.4-1208](https://jdbc.postgresql.org/download.html) (or later)
* Participants are requested to `git clone` this project and follow [README](README.md).
