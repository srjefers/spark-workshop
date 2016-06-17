# Spark Administration and Monitoring Workshop

## What You Will Learn (aka Goals)

The goal of the **Spark Administration and Monitoring Workshop** is to give you a practical, complete and hands-on introduction to [Apache Spark](http://spark.apache.org/) and the tools to **manage**, **monitor**, **troubleshoot** and **fine-tune Spark infrastructure**.

**NOTE**: The workshop uses a tailor-made Docker image but it is also possible to use a commercial distribution for Spark like [Cloudera's CDH](http://www.cloudera.com/downloads/quickstart_vms/5-7.html) (possibly [Hortonworks Data Platform (HDP)](http://hortonworks.com/products/hdp/) or [MapR Sandbox](https://www.mapr.com/products/mapr-sandbox-hadoop/download)).

The workshop uses an intense **learn-by-doing** approach in which the modules start with just enough knowledge to get you going and quickly move on to applying the concepts in assignments. There are a lot of practical exercises.

The workshop comes with many practical sessions that should meet (and possibly exceed) expectations of administrators, operators, devops, and other technical roles like system architects or technical leads (perhaps also software developers for whom [Spark and Scala (Application Development) Workshop](AGENDA.md) might be a better fit).

**CAUTION**: The workshop is very hands-on and practical, i.e. not for faint-hearted. _Seriously!_ After just a couple of days your mind, eyes, and hands will all be trained to recognise the patterns how to set up and operate Spark infrastructure in your Big Data projects.

**CAUTION** I have already trained people who expressed their concern that there were too many exercises. _Your dear drill sergeant, Jacek._

## Duration

5 days

## Target Audience

* Aspiring Spark administrators, operators, devops
* Perhaps system architects or technical leads

## Agenda

1. Anatomy of Spark Data Processing
  1. `SparkContext`
      * SparkConf
  1. Transformations and Actions
  1. Units of Physical Execution: Jobs, Stages, and Tasks
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
  1. Deploy Modes
  1. Spark Clusters
      * Master and Workers
  1. RPC Environment (RpcEnv)
  1. BlockManagers
1. Spark Tools
  1. `spark-shell`
  1. `spark-submit`
  1. web UI
  1. `spark-class`
1. Monitoring Spark Applications using web UI
  1. The Different Tabs in web UI
  1. Exercise: Monitoring using web UI
      * Executing Spark Jobs to Enable Different Statistics and Statuses
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
1. Clustering Spark using Spark Standalone
  1. Exercise: Setting up Spark Standalone
      * Using standalone Master's web UI
  1. Exercise: Submitting Applications using spark-submit
      * `--master spark://...`
      * `--deploy-mode` with `client` and `cluster`
  1. Clustering Spark using Spark Standalone
1. Tuning Spark Infrastructure
  1. Exercise: Configuring CPU and Memory for Master and Executors
  1. Exercise: Observing Shuffling using `groupByKey`-like operations.
  1. Scheduling Modes: FIFO and FAIR
      * Exercise: Configuring Pools in FAIR Scheduling Mode
1. Monitoring Spark using `SparkListeners`
  1. `LiveListenerBus`
  1. `StatsReportListener`
  1. Event Logging using `EventLoggingListener` and History Server
  1. Exercise: Event Logging using `EventLoggingListener`
  1. Exercise: Developing Custom SparkListener
1. Dynamic Allocation (of Executors)
  1. External Shuffle Service
1. Spark Metrics System
1. (optional) Using Spark Streaming and Kafka
1. (optional) Clustering Spark using Apache Mesos
  1. Exercise: Setting up Mesos cluster
  1. Exercise: Submitting Applications using `spark-submit`
      * `--master mesos://...`

## Requirements

* Training classes are best for groups up to 8 participants.
* Participants have decent computers, preferably with Linux or Mac OS operating systems
  * [There are issues with running Spark on Windows](https://jaceklaskowski.gitbooks.io/mastering-apache-spark/content/spark-tips-and-tricks-running-spark-windows.html) (mostly with Spark SQL / Hive).
* Participants have to download the following packages to their computers before the class:
  * [spark-1.6.1-bin-hadoop2.6.tgz](http://www.apache.org/dyn/closer.lua/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz)
  * Optional downloads (have them ready):
    * [kafka_2.11-0.10.0.0.tgz](https://www.apache.org/dyn/closer.cgi?path=/kafka/0.10.0.0/kafka_2.11-0.10.0.0.tgz)
    * [H2 Database Engine](http://www.h2database.com/html/main.html) - download [zip file with Version 1.4.191 for All Platforms](http://www.h2database.com/h2-2016-01-21.zip)
    * [apache-cassandra-3.6-bin.tar.gz](http://www.apache.org/dyn/closer.lua/cassandra/3.6/apache-cassandra-3.6-bin.tar.gz)
    * [Cassandra Spark Connector](http://spark-packages.org/package/datastax/spark-cassandra-connector) by executing the following command: `$SPARK_HOME/bin/spark-shell --packages datastax:spark-cassandra-connector:1.6.0-M2-s_2.11`
    * (optional) [PostgreSQL 9.5.2](http://www.postgresql.org/download/) (or later) and [JDBC42 Postgresql Driver 9.4-1208](https://jdbc.postgresql.org/download.html) (or later)
* Participants are requested to `git clone` this project and follow [README](README.md).
