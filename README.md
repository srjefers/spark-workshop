# Spark Workshops for Developers, Administrators and Operators

This project aims to prepare participants with the proper setup for the **Spark and Scala Workshops** run by [Jacek Laskowski](https://twitter.com/jaceklaskowski).

There are two Spark workshops offered currently:

* [Spark and Scala (Application Development) Workshop](AGENDA.md)
* [Spark Administration and Monitoring Workshop](AGENDA-admin.md)

**CAUTION**: The workshops are very hands-on and practical, and certainly not for faint-hearted. _Seriously!_ After 5 days your mind, eyes, and hands will all be trained to recognize the patterns where and how to use Spark and Scala in your Big Data projects.

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
