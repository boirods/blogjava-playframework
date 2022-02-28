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
    "org.xerial" % "sqlite-jdbc" % "3.36.0.3",
	"com.typesafe.play" %% "play-ebean" % "6.2.0-RC4",
	"io.ebean" % "ebean-test" % "12.15.0" % Test
)
