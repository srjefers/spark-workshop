package pl.japila.spark

import org.apache.spark.sql.SparkSession

object JoinApp extends App {

  val spark = SparkSession.builder.getOrCreate
  import spark.implicits._

  val airports = Seq(
    ("NCE", "Nice"),
    ("WAW", "Warsaw"),
    ("JFK", "NYC")).toDF("code", "city")

  val departures = Seq(
    ("NCE", "WAW", "8:30"),
    ("WAW", "JFK", "9:25")).toDF("start", "end", "time")

  // Exercise: Change the codes to corresponding city names

  // ERROR: Cross join
  departures.join(airports).show

  // All three are equivalent
  departures.join(airports, $"start" === $"code").show
  departures.join(airports).where($"start" === $"code").show
  departures.join(airports).filter($"start" === $"code").show

  // ERROR: Ambiguous column
  // Reference 'code' is ambiguous
  departures
    .join(airports, $"start" === $"code")
    .join(airports, $"end" === $"code")
    .select("city", "end", "time")

  val timetable = departures
    .join(airports)
    .where($"start" === $"code")
    .select("city", "end", "time")

  // ERROR: Compiles but gives two the same city columns
  timetable.join(airports)
    .where($"end" === $"code")
    .select(timetable("city"), airports("city"), $"time")
    .show

  val flights = timetable
    .as("tt")
    .join(airports.as("cs"))
    .where($"end" === $"code")
    .select($"tt.city" as "departure", $"cs.city" as "arrival", $"time")
  flights.show
}
