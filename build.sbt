val scalaVersion = "3.3.0"

lazy val root = project.in(file("jvm")).settings(
  libraryDependencies ++= Seq("com.google.budoux" % "budoux" % "0.5.2"),
  libraryDependencies ++= Seq("org.scalameta" %% "munit" % "0.7.29" % Test),
)

