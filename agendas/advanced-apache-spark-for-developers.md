# Advanced Apache Spark for Developers Workshop (5 days)

## What You Will Learn / Objectives

The goal of the **Advanced Apache Spark for Developers Workshop** is to build the deeper understanding of the internals of Apache Spark (Spark Core) and the modules in Apache Spark 2 (Spark SQL, Spark Structured Streaming and Spark MLlib). The workshop will teach you how to do performance tuning of Apache Spark applications and the more advanced features of Apache Spark 2.

**NOTE** The workshop uses the latest and greatest [Apache Spark 2.2.0](http://spark.apache.org/releases/spark-release-2-2-0.html) and is particularly well-suited to Spark developers who worked with Apache Spark 1.x.

The workshop follows a very intense **learn-by-doing** approach in which the modules start with just enough knowledge to get you going and quickly move on to applying the concepts in practical exercises.

The workshop includes many practical sessions that should meet (and quite likely exceed) expectations of software developers with a significant experience in Apache Spark and a good knowledge of Scala, senior administrators, operators, devops, and senior support engineers.

**CAUTION**: The workshop is very hands-on and practical, i.e. not for faint-hearted. _Seriously!_ After just a couple of days your mind, eyes, and hands will all be trained to recognise the patterns how to set up and operate Spark infrastructure for your Big Data and Predictive Analytics projects.

## Duration

5 days

## Target Audience

* Experienced Software Developers
  * Good knowledge of Scala
  * Significant experience in Apache Spark 1.x
* Senior Administrators
* Senior Support Engineers

## Agenda

### Spark Core (1.5 Days)

1. Anatomy of Spark Core Data Processing
    1. `SparkContext` and `SparkConf`
    1. Transformations and Actions
    1. Units of Physical Execution: Jobs, Stages, Tasks and Job Groups
    1. RDD Lineage
        * DAG View of RDDs
        * Logical Execution Plan
    1. Spark Execution Engine
        * DAGScheduler
        * TaskScheduler
        * Scheduler Backends
        * Executor Backends
    1. Partitions and Partitioning
    1. Shuffle
    1. Caching and Persistence
    1. Checkpointing
1. Elements of Spark Runtime Environment
    1. The Driver and Executors
    1. Deploy Modes
    1. Spark Clusters
        * Master and Workers
1. Spark Tools
    * `spark-shell`
    * `spark-submit`
    * `spark-class`
1. Troubleshooting and Monitoring
    1. web UI
    1. Log Files
    1. `SparkListeners`
        * `StatsReportListener`
        * Event Logging using `EventLoggingListener` and History Server
        * Exercise: Event Logging using `EventLoggingListener`
        * Exercise: Developing Custom SparkListener
    1. Spark Metrics System
1. Tuning Spark Infrastructure
    1. Exercise: Configuring CPU and Memory for Driver and Executors
    1. Scheduling Modes: FIFO and FAIR
    1. Exercise: Configuring Pools in FAIR Scheduling Mode

### Spark SQL (2 Days)

1. `SparkSession`
1. Dataset, DataFrame and Encoders
1. `QueryExecution` — Query Execution of Dataset
1. Exercise: Debugging Query Execution
1. web UI
1. DataSource API
1. Columns, Operators, Standard Functions and UDFs
1. Joins
1. Basic Aggregation
  * **groupBy** and **groupByKey** operators
  * [Case Study: Number of Partitions for groupBy Aggregation](https://jaceklaskowski.gitbooks.io/mastering-apache-spark/spark-sql-performance-tuning-groupBy-aggregation.html)
1. Windowed Aggregation
1. Multi-Dimensional Aggregation
1. Caching and Persistence
1. Catalyst — Tree Manipulation Framework
    1. Expressions, LogicalPlans and SparkPlans
    1. Logical and Physical Operators
1. Analyzer — Logical Query Plan Analyzer
1. SparkOptimizer — Logical Query Optimizer
    1. Logical Plan Optimizations
1. SparkPlanner — Query Planner with no Hive Support
    1. Execution Planning Strategies
1. Physical Plan Preparations Rules
1. Tungsten Execution Backend (aka Project Tungsten)
    1. Whole-Stage Code Generation (aka Whole-Stage CodeGen)
    1. InternalRow and UnsafeRow

### Spark Structured Streaming (0.5 Days)

1. [Spark Structured Streaming](../spark-structured-streaming-workshop.md)

### Spark MLlib (1 Day)

1. ML Pipelines and PipelineStages (spark.ml)
1. ML Pipeline Components
    1. Transformers
    1. Estimators
    1. Models
    1. Evaluators
    1. CrossValidator
    1. Params (and ParamMaps)
1. Supervised and Unsupervised Learning with Spark MLlib
    1. Classification and Regression
    1. Clustering
    1. Collaborative Filtering
1. Model Selection and Tuning
1. ML Persistence — Saving and Loading Models and Pipelines

## Requirements

* Training classes are best for groups up to 12 participants
* Participants have decent computers, preferably with Linux or Mac OS operating systems
  * [There are issues with running Spark on Windows](https://jaceklaskowski.gitbooks.io/mastering-apache-spark/content/spark-tips-and-tricks-running-spark-windows.html) (mostly with Spark SQL / Hive).
* Participants should install the following packages:
  * [Apache Spark 2.2](http://spark.apache.org/downloads.html)
  * [Java SE Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  * [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/) with the [Scala plugin](https://www.jetbrains.com/help/idea/creating-and-running-your-scala-application.html)
  * [sbt](http://www.scala-sbt.org/download.html)
  * [Apache Kafka 0.11.0.1](http://kafka.apache.org/downloads)
  * [PostgreSQL 10](http://www.postgresql.org/download/) or any other relational database
* Participants should download the following packages:
  * [PostgreSQL JDBC 4.2 Driver, 42.1.4](https://jdbc.postgresql.org/download.html)
