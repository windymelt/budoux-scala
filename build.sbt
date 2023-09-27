import org.scalajs.linker.interface.ModuleSplitStyle
import org.scalajs.linker.interface.OutputPatterns

val ScalaVersion = "3.3.0"

ThisBuild / organization := "io.github.windymelt"
ThisBuild / organizationName := "windymelt"
ThisBuild / organizationHomepage := Some(url("https://github.com/windymelt"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/windymelt/budoux-scala"),
    "scm:git@github.windymelt/budoux-scala.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id = "windymelt",
    name = "windymelt",
    email = "windymelt@3qe.us",
    url = url("https://github.com/windymelt/budoux-scala")
  )
)

ThisBuild / description := "Scala binding for BudouX"
ThisBuild / licenses := List(
  "BSD 3 Clause" -> new URL("https://opensource.org/license/bsd-3-clause/")
)
ThisBuild / homepage := Some(url("https://github.com/windymelt/budoux-scala"))
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

ThisBuild / publishMavenStyle := true
lazy val root = project
  .in(file("."))
  .aggregate(budouxs.js, budouxs.jvm)
  .settings(
    publish := {},
    publishLocal := {}
  )

lazy val budouxs = crossProject(JSPlatform, JVMPlatform)
  .in(file("."))
  .settings(
    scalaVersion := ScalaVersion,
    name := "budouxs",
    version := "0.1-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.scalatest" %%% "scalatest" % "3.2.17" % Test
    )
  )
  .jvmSettings(
    libraryDependencies ++= Seq("com.google.budoux" % "budoux" % "0.5.2")
  )
  .jsSettings(
    // See js/scalajs.sbt for sbt plugin settings.
    useYarn := true,
    Test / scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withOutputPatterns(OutputPatterns.fromJSFile("%s.mjs"))
    },
    scalaJSUseMainModuleInitializer := true,
    Compile / npmDependencies ++= Seq(
      "budoux" -> "0.5.2" // budoux has built-in TypeScript type definitions
    ),
    scalaJSLinkerConfig ~= (_.withModuleSplitStyle(
      ModuleSplitStyle.FewestModules
    )),
    stOutputPackage := "io.github.windymelt.budouxs.internal"
  )
