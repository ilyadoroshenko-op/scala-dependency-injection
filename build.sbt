name := "DI4API"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.softwaremill.macwire" %% "macros" % "2.2.5" % "provided",
  "com.softwaremill.macwire" %% "util" % "2.2.5",
  "com.softwaremill.macwire" %% "proxy" % "2.2.5",
  "org.scalatest" % "scalatest_2.11" % "3.0.1",
  "org.mockito" % "mockito-core" % "2.6.8"
)