name := "ca"

version := "0.1.0"

organization := "com.awaresec"

scalaVersion := "2.12.1"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

libraryDependencies ++= Seq(
  "org.specs2"        %% "specs2-core"        % "3.8.8"          % "test"
)
