# Spark Administration Workshop

## What You Will Learn (aka Goals)

The goal of the **Spark Administration** is to give you a practical, complete and hands-on introduction to [Apache Spark](http://spark.apache.org/) and how to **manage, monitor, and fine-tune Spark infrastructure**.

The workshop uses an intense **learn-by-doing** approach in which the modules start with just enough knowledge to get you going and quickly move on to applying the concepts in assignments. There are a lot of practical exercises.

The workshop comes with many practical sessions that should meet (and possibly exceed) expectations of administrators, operators, devops, and other technical roles like system architects or technical leads (perhaps also software developers for whom [Spark and Scala (Application Development) Workshop](AGENDA.md) might be a better fit).

**CAUTION**: The workshop is very hands-on and practical, i.e. not for faint-hearted. _Seriously!_ After just a couple of days your mind, eyes, and hands will all be trained to recognise the patterns how to set up and operate Spark infrastructure in your Big Data projects.

**CAUTION** I have already trained people who expressed their concern that there were too many exercises. _Your dear drill sergeant, Jacek._

## Duration

4 days

## Target Audience

* Aspiring Spark administrators, operators, devops
* Perhaps system architects or technical leads

## Outcomes

After completing the workshop participants should be able to:

* ...FIXME

## Agenda

### Spark Administration

1. Monitoring Spark Applications using web UI
  1. Jobs, Stages, Tasks, and Shuffling
  1. Caching and Storage Tab
  1. Exercise: Monitoring using web UI
1. Clustering Spark using Spark Standalone
  1. Exercise: Setting up Spark Standalone
      * Using standalone Master's web UI
  1. Exercise: Submitting Applications using spark-submit
      * `--master spark://...`
      * `--deploy-mode` with `client` and `cluster`
1. Tuning Spark Infrastructure
  1. Exercise: Configuring CPU and Memory for Master and Executors
  1. Exercise: Observing Shuffling using `groupByKey`-like operations.
  1. Exercise: High-Availability of standalone Master using Apache ZooKeeper
1. Clustering Spark using Apache Mesos
  1. Exercise: Setting up Mesos cluster
  1. Exercise: Submitting Applications using `spark-submit`
      * `--master mesos://...`
1. Clustering Spark using Hadoop YARN
  1. Exercise: Setting up Hadoop YARN
      * Accessing Resource Manager's web UI
  1. Exercise: Submitting Applications using `spark-submit`
      * `--master yarn`
      * `yarn-site.xml`
      * `yarn application -list`
      * `yarn application -status`
      * `yarn application -kill`
1. Monitoring Spark using SparkListeners
  1. `StatsReportListener`
  1. Event Logging using `EventLoggingListener` and History Server
  1. Exercise: Event Logging using `EventLoggingListener`
  1. Exercise: Developing Custom SparkListener
1. Dynamic Allocation (of Executors)
  1. External Shuffle Service

## Requirements

* Training classes are best for groups up to 8 participants.
* Participants have decent computers, preferably with Linux or Mac OS operating systems
  * [There are issues with running Spark on Windows](https://jaceklaskowski.gitbooks.io/mastering-apache-spark/content/spark-tips-and-tricks-running-spark-windows.html) (mostly with Spark SQL / Hive).
* Participants have to download the following packages to their computers before the class:
  * [spark-1.6.1-bin-hadoop2.6.tgz](http://www.apache.org/dyn/closer.lua/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz)
  * Optional downloads (have them ready):
    * [kafka_2.11-0.9.0.1.tgz](https://www.apache.org/dyn/closer.cgi?path=/kafka/0.9.0.1/kafka_2.11-0.9.0.1.tgz)
    * [H2 Database Engine](http://www.h2database.com/html/main.html) - download [zip file with Version 1.4.191 for All Platforms](http://www.h2database.com/h2-2016-01-21.zip)
    * [apache-cassandra-3.4-bin.tar.gz](http://www.apache.org/dyn/closer.lua/cassandra/3.4/apache-cassandra-3.4-bin.tar.gz)
    * [Cassandra Spark Connector 1.6.0-M1](http://spark-packages.org/package/datastax/spark-cassandra-connector) by executing the following command: `$SPARK_HOME/bin/spark-shell --packages datastax:spark-cassandra-connector:1.6.0-M1-s_2.10`
    * (optional) [PostgreSQL 9.5.2](http://www.postgresql.org/download/) (or later) and [JDBC42 Postgresql Driver 9.4-1208](https://jdbc.postgresql.org/download.html) (or later)
* Participants are requested to `git clone` this project and follow [README](README.md).
