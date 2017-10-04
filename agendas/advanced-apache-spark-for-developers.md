# Advanced Apache Spark for Developers Workshop (5 days)

## What You Will Learn (aka Objectives)

The goal of the **Advanced Apache Spark for Developers Workshop** is to understand the internals of Apache Spark 2.x and the modules (Spark SQL, Spark Structured Streaming and Spark MLlib). The workshop will give you a deep understanding of performance tuning of Apache Spark applications and the advanced features of Apache Spark.

**NOTE** The workshop uses the latest and greatest **Apache Spark 2.2.0**.

The workshop uses an intense **learn-by-doing** approach in which the modules start with just enough knowledge to get you going and quickly move on to applying the concepts in assignments.

The workshop includes many practical sessions that should meet (and quite possibly exceed) expectations of software developers with a significant experience in Apache Spark and a good knowledge of Scala, senior administrators, operators, devops, and senior support engineers.

**CAUTION**: The workshop is very hands-on and practical, i.e. not for faint-hearted. _Seriously!_ After just a couple of days your mind, eyes, and hands will all be trained to recognise the patterns how to set up and operate Spark infrastructure in your Big Data and Predictive Analytics projects.

**CAUTION** I have already trained people who expressed their concern that there were too many exercises. _Your dear drill sergeant, Jacek._

## Duration

5 days

## Target Audience

* Experienced Software Developers
  * Significant experience of Apache Spark
  * Good knowledge of Scala
* Senior Administrators
* Senior Support Engineers

## Agenda

### Day 1 &mdash; Spark Core

1. Anatomy of Spark Core Data Processing
  1. `SparkContext`, `SparkConf`
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
      * Wide and Narrow Dependencies
  1. Caching and Persistence
  1. Checkpointing
1. Elements of Spark Runtime Environment
  1. The Driver
  1. Executors
      * TaskRunners
      * BlockManagers
  1. RPC Environment (RpcEnv)
  1. Deploy Modes
  1. Spark Clusters
      * Master and Workers
1. Spark Tools
  1. `spark-shell`
  1. `spark-submit`
  1. `spark-class`
1. Monitoring Spark Applications using web UI
  1. The Different Tabs in web UI
  1. Exercise: Monitoring using web UI
      * Executing Spark Jobs to Enable Different Statistics and Statuses

### Day 2 &mdash; Spark Core

1. Spark on Hadoop YARN cluster
  1. Exercise: Setting up Hadoop YARN
      * Accessing Resource Manager's web UI
  1. Exercise: Submitting Applications using `spark-submit`
      * `--master yarn`
      * `yarn-site.xml`
      * `yarn application -list`
      * `yarn application -status`
      * `yarn application -kill`
  1. [Runtime Properties](http://spark.apache.org/docs/latest/running-on-yarn.html#spark-properties) - Meaning and Application
  1. Troubleshooting
      * log files
  1. YarnShuffleService -- ExternalShuffleService on YARN
  1. Multi-tenant YARN Cluster Setup and Spark
      * Overview of YARN Schedulers (e.g. Capacity Scheduler)
      * `spark-submit --queue`
1. Tuning Spark Infrastructure
  1. Exercise: Configuring CPU and Memory for Driver and Executors
  1. Scheduling Modes: FIFO and FAIR
      * Exercise: Configuring Pools in FAIR Scheduling Mode
1. Monitoring Spark using `SparkListeners`
  1. `LiveListenerBus`
  1. `StatsReportListener`
  1. Event Logging using `EventLoggingListener` and History Server
  1. Exercise: Event Logging using `EventLoggingListener`
  1. Exercise: Developing Custom SparkListener

### Day 3 &mdash; Spark SQL

1. `SparkSession` vs `SparkContext`
1. Dataset, DataFrame and Encoders
1. QueryExecution — Query Execution of Dataset
1. Exercise: Debugging Query Execution
1. web UI
1. Joins, esp. Broadcast Joins
1. Caching and Persistence
1. DataSource API
1. Exercise: Observing Shuffling with Aggregations operations.
1. [Case Study: Number of Partitions for groupBy Aggregation](https://jaceklaskowski.gitbooks.io/mastering-apache-spark/spark-sql-performance-tuning-groupBy-aggregation.html)
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

### Day 4 &mdash; Spark Structured Streaming

1. [Spark Structured Streaming](../spark-structured-streaming-workshop.md)

### Day 5 &mdash; Spark MLlib

1. ML Pipelines and PipelineStages (spark.ml)
1. ML Pipeline Components
  1. Transformers
  1. Estimators
  1. Models
  1. Evaluators
  1. CrossValidator
  1. Params (and ParamMaps)
1. ML Persistence — Saving and Loading Models and Pipelines
1. Exercise: Text Classification
1. Exercise: Linear Regression
1. Exercise: Classification using K-Means

## Requirements

* Training classes are best for groups up to 12 participants.
* Participants have decent computers, preferably with Linux or Mac OS operating systems
  * [There are issues with running Spark on Windows](https://jaceklaskowski.gitbooks.io/mastering-apache-spark/content/spark-tips-and-tricks-running-spark-windows.html) (mostly with Spark SQL / Hive).
* Participants have to install the following packages on their computers before the class:
  * [Apache Spark 2.2](http://spark.apache.org/downloads.html)
  * [Apache Kafka 0.11.0.1](http://kafka.apache.org/downloads)
  * [PostgreSQL 9.6.5](http://www.postgresql.org/download/)
  * [PostgreSQL JDBC 4.2 Driver, 42.1.4](https://jdbc.postgresql.org/download.html)
