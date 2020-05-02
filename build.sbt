name := "saver"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq(
  "net.debasishg" %% "redisclient" % "3.20",
  "com.amazonaws" % "aws-java-sdk" % "1.11.46",
  "javax.xml.bind" % "jaxb-api" % "2.3.1"

)
