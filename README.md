# Apache Spark™ and Scala Workshops for Software Developers, Administrators, Operators and Architects

This repository contains the materials (i.e. agendas, slides, code) for **Apache Spark™ and Scala workshops** led by [Jacek Laskowski](https://twitter.com/jaceklaskowski).

- Have you ever thought about learning Apache Spark™ or Scala?
- Would you like to gain expertise in the tools used for Big Data and Predictive Analytics but you don't know where to start?
- Do you know the basics of Apache Spark™ and have been wondering how to reach the higher levels of expertise?

If you answered **YES** to one or more questions above, I have good news for you! Join one of the following Apache Spark™ workshops and become a Apache Spark™ pro.

1. [Advanced Apache Spark for Developers Workshop (5 days)](agendas/advanced-apache-spark-for-developers.md)
1. [Spark Structured Streaming (Apache Spark 2.2) Workshop](spark-structured-streaming-workshop.md)
1. [Spark and Scala (Application Development) Workshop](AGENDA.md)
1. [Spark Administration and Monitoring Workshop](AGENDA-admin.md)
1. [Spark and Scala Workshop for Developers (1 Day)](AGENDA-ONE-DAY.md)

You can find the slides for the above workshops and others at [Apache Spark Workshops and Webinars](slides/README.md#toc) page.

**CAUTION**: The workshops are very hands-on and practical, and certainly not for faint-hearted. _Seriously!_ After 5 days your mind, eyes, and hands will all be trained to recognize the patterns where and how to use Spark and Scala in your Big Data projects.

---

## Apache Spark™ Workshop Setup

`git clone` the project first and execute `sbt test` in the cloned project's directory.

```
$ sbt test
...
[info] All tests passed.
[success] Total time: 3 s, completed Mar 10, 2016 10:37:26 PM
```

You should see `[info] All tests passed.` to consider yourself prepared.

## Docker Image

Execute the following command to have a complete Docker image for the workshop.

NOTE: It was tested on Mac OS only. I assume that `-v` in the command will not work on Windows and need to be changed to appropriate environment settings.

```
docker run -ti -p 4040:4040 -p 8080:8080 -v "$PWD:/home/spark/workspace" -v "$HOME/.ivy2":/home/spark/.ivy2 -h spark --name=spark jaceklaskowski/docker-spark
```
