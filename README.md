# Apache Spark™ and Scala Workshops

This repository contains the materials (i.e. [agendas](slides/#agendas), [slides](slides/#unit-1-spark-sql-for-large-scale-structured-data-processing), [demo](demo), [exercises](exercises)) for [Apache Spark™](http://spark.apache.org/) and [Scala](https://www.scala-lang.org/) workshops led by [Jacek Laskowski](https://twitter.com/jaceklaskowski).

- Have you ever thought about learning Apache Spark™ or Scala?
- Would you like to gain expertise in the tools used for Big Data and Predictive Analytics but you don't know where to start?
- Do you know the basics of Apache Spark™ and have been wondering how to reach the higher levels of expertise?
- Are you considering a Apache Spark™ Developer Certification from companies like Databricks, Cloudera, Hortonworks or MapR?

If you answered **YES** to any of the questions above, I have good news for you! Join one of the following Apache Spark™ workshops and become a Apache Spark™ pro.

1. [Advanced Apache Spark for Developers Workshop (5 days)](agendas/advanced-apache-spark-for-developers.md)
2. [Spark Structured Streaming Workshop (Apache Spark 2.3)](spark-structured-streaming-workshop.md)
3. [Spark and Scala (Application Development) Workshop](AGENDA.md)
4. [Spark Administration and Monitoring Workshop](AGENDA-admin.md)
5. [Spark and Scala Workshop for Developers (1 Day)](AGENDA-ONE-DAY.md)

You can find the slides for the above workshops and others at [Apache Spark Workshops and Webinars](slides/README.md#toc) page.

No prior experience with Apache Spark or Scala required.

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

```bash
docker run -ti -p 4040:4040 -p 8080:8080 -v "$PWD:/home/spark/workspace" -v "$HOME/.ivy2":/home/spark/.ivy2 -h spark --name=spark jaceklaskowski/docker-spark
```

## Contact The Author

- Read [Mastering Apache Spark](https://bit.ly/mastering-apache-spark)
- Read [Mastering Spark SQL](https://bit.ly/mastering-spark-sql)
- Read [Mastering Spark Structured Streaming](https://bit.ly/spark-structured-streaming)
- Follow [@jaceklaskowski](https://twitter.com/jaceklaskowski) on twitter
- Upvote [Jacek Laskowski's questions and answers on StackOverflow](http://stackoverflow.com/users/1305344/jacek-laskowski)
- Use [Jacek's code on GitHub](https://github.com/jaceklaskowski)
- Read [blog posts on Medium](https://medium.com/@jaceklaskowski)
- Upvote [Jacek's answers on Quora](https://www.quora.com/profile/Jacek-Laskowski)
- Connect [on LinkedIn](https://www.linkedin.com/in/jaceklaskowski/)
- Visit [Jacek Laskowski's blog](https://blog.jaceklaskowski.pl)
