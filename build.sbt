name := """BlogJava"""
organization := "top.rregio"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
    javaCore,
    javaJpa,
    javaWs,
    javaJdbc,
    guice,
    "org.postgresql" % "postgresql" % "42.3.2",
)
