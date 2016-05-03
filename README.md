# Spark and Scala Workshop

This project aims to prepare participants with the proper setup for the **Spark and Scala Workshop** run by [Jacek Laskowski](https://twitter.com/jaceklaskowski).

You can find the workshop agenda in [AGENDA](AGENDA.md) file in the repository.

**CAUTION**: The Spark and Scala workshop is very hands-on and practical, i.e. not for faint-hearted. _Seriously!_ After 4 days your mind, eyes, and hands will all be trained to recognize the patterns where and how to use Spark and Scala in your Big Data projects.

`git clone` it first and execute `sbt test` in the cloned project's directory.

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
