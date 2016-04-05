## What You Will Learn (aka Goals)

The goal of the workshop is to give you a practical hands-on introduction to Apache Spark and how to use Spark's Scala API (developer) and infrastructure (administrator, devops) effectively.

Please note that the workshop uses an intense code-first approach in which the modules start with just enough knowledge to get you going (through slides and scaladoc) and quickly move on to applying the concepts in programming assignments. It comes with many practical sessions that should meet expectations of software developers (and quite likely exceed expectations of administrators, devops, and other technical roles like system architects or technical leads).

The workshop provides participants with practical skills to use the features of Apache Spark with Scala.

## Duration

4 days

## Target Audience

* Software developers who know Scala and want to explore the Spark space
* Software developers with programming experience in a similar general-purpose programming language (Java, Python, Ruby)

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
* Understand the concepts of Spark SQL
* Understand the concepts of Spark Streaming
* Understand the concepts of Spark MLlib
* Build processing pipelines using Spark's RDD and abstractions above in Spark SQL (DataFrame), Spark Streaming (DStream), and Spark MLlib (Pipeline API).
* Explain the internals of Spark and execution model

## Agenda

The programming language to use during the course is [Scala](http://www.scala-lang.org/). There is a one-day "crash course" to the language during the workshop. It is optional for skilled Scala developers who are familiar with the fundamentals of Scala.

### Scala (one-day crash course)

This module aims at introducing Scala and the tools, i.e. sbt and Scala REPL, to complete the other Spark modules.

This module requires Internet access to download sbt and plugins.

This module covers:

* Scala REPL
* Literals and Values
* Basic Types (Numerics, Strings)
* More Advanced Types (Tuples, Options)
* Expressions and Conditions
* Methods and Functions
* Scala Collection API and Common Collection Types
  * Seqs, Lists, Sets, Maps
* Command-line Applications
* Packages
* Case Classes, Objects, and Traits
* Pattern Matching

Agenda:

1. Using sbt
  1. The tasks: `help`, `compile`, `test`, `package`, `update`, `~`, `set`, `show`, `console`
  1. Tab experience
  1. Configuration files and directories, i.e. `build.sbt`, `project` directory
1. Adding new tasks to sbt through plugins
  1. Global vs project plugins
  1. [sbt-assembly](https://github.com/sbt/sbt-assembly)
  1. [sbt-updates](https://github.com/rtimush/sbt-updates)

### Spark Core

1. Installing Spark and My First Spark Application (using spark-shell)
  1. Exercise: Word Counter = Counting words in README.md
1. Using Spark’s Core APIs in Scala - Transformations and Actions
  1. Exercise: Key-value pair operators
1. Building, Deploying and Monitoring Spark Applications (using sbt, spark-submit, and web UI)
  1. Exercise: A Complete Development Cycle of Spark Application
1. Processing Structured Data using RDDs
  1. Traditional / Old-Fashioned Approach
  1. Exercise: Accessing Data in CSV
  1. Exercise: Accessing Data in Apache Cassandra
1. Monitoring Spark Applications using web UI
  1. Jobs, Stages, Tasks, and Shuffling
  1. Caching and Storage Tab
  1. Exercise: Monitoring using web UI
1. Clustering Spark and Spark Standalone
  1. Exercise: Setting up Spark Standalone
  1. Exercise: Deploying Applications using spark-submit (`--master` and `--deploy-mode`)
1. Tuning Spark Infrastructure
  1. Exercise: Configuring CPU and Memory for Master and Executors
  1. Exercise: Observing Shuffling using `groupByKey`-like operations.

### Spark SQL

1. Spark SQL and DataFrames
  1. Exercise: Creating DataFrames
      * `toDF`
      * `SQLContext.createDataFrame` and Explicit Schema using `StructType`
  1. Exercise: Manipulating data from CSV using DataFrames
      * `SQLContext.read.csv` vs `SQLContext.read.format("csv")`
      * `count`
1. DataFrames and Query DSL
  1. Exercise: Using Query DSL to select columns
  1. Exercise: `withColumn`
1. functions object
  1. Exercise: Manipulating DataFrames using functions
    * `withColumn` and `split`
1. Spark SQL and Datasets
  1. Exercise: WordCount using `SQLContext.read.text`
    * `withColumn` and `split`
1. Caching
  1. Exercise: Measuring Query Times using web UI
1. Aggregating
  1. Exercise: Using `groupBy`
  1. Exercise: Compute Aggregates using `mapGroups`
    * Word Count using Datasets
1. Accessing Structured Data using JDBC
  1. Modern / New-Age Approach
  1. Exercise: Reading Data from and Writing to MySQL
1. User-Defined Functions (UDFs)
  1. Exercise: Using UDFs to create new DataFrames
1. Integration with Hive
  1. Queries over DataFrames
  1. Registering UDFs
  1. Temporary and permanent tables

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

### Spark MLlib

1. Transformers
  1. Exercise: Using Tokenizer, RegexTokenizer, and HashingTF
1. Estimators
  1. Exercise: Using KMeans
    * Fitting a model and checking spams
  1. Exercise: Using LogisticRegression
    * Fitting a model and checking spams
1. Pipelines
  1. Exercise: Using Pipelines of Transformers and Estimators

### Extras

1. Exercise: Stream Processing using Spark Streaming, Spark SQL and Spark MLlib (Pipeline API).

## Requirements

* Training classes are best for groups up to 8 participants.
* Experience of software development using modern programming language (Scala, Java, Python, Ruby) is recommended. The workshop introduces Scala only enough to develop Spark applications using Scala API.
* Participants have decent computers, preferably with Linux or Mac OS operating systems
  * [There are issues with running Spark on Windows](https://jaceklaskowski.gitbooks.io/mastering-apache-spark/content/spark-tips-and-tricks-running-spark-windows.html) (mostly with Spark SQL / Hive).
* Participants have to download the following packages to their computers before the class:
  * [spark-1.6.1-bin-hadoop2.6.tgz](http://www.apache.org/dyn/closer.lua/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz)
  * [sbt-0.13.11.zip](https://dl.bintray.com/sbt/native-packages/sbt/0.13.11/sbt-0.13.11.zip)
  * [IntelliJ IDEA Community Edition 2016.1.1](https://www.jetbrains.com/idea/download/) (or equivalent development environment)
    * Install [Scala plugin](https://plugins.jetbrains.com/plugin/?id=1347)
  * [kafka_2.11-0.9.0.1.tgz](https://www.apache.org/dyn/closer.cgi?path=/kafka/0.9.0.1/kafka_2.11-0.9.0.1.tgz)
  * [H2 Database Engine](http://www.h2database.com/html/main.html) - download [zip file with Version 1.4.191 for All Platforms](http://www.h2database.com/h2-2016-01-21.zip)
  * [apache-cassandra-3.4-bin.tar.gz](http://www.apache.org/dyn/closer.lua/cassandra/3.4/apache-cassandra-3.4-bin.tar.gz)
  * [Cassandra Spark Connector 1.6.0-M1](http://spark-packages.org/package/datastax/spark-cassandra-connector) by executing the following command: `$SPARK_HOME/bin/spark-shell --packages datastax:spark-cassandra-connector:1.6.0-M1-s_2.10`
  * (optional) Apache MySQL and MySQL JDBC Driver
* Participants are requested to `git clone` this project and follow README.md.
