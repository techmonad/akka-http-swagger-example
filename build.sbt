name := "akka-http-swagger-example"

version := "0.1"

scalaVersion := "2.13.5"

val AkkaVersion = "2.6.15"
val AkkaHttpVersion = "10.2.4"


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "org.json4s" %% "json4s-native" % "4.0.4"
)