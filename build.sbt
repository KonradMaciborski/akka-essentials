ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.7"

lazy val root = (project in file("."))
  .settings(
    name := "akka-essentials"
  )
