import org.scalajs.linker.interface.ModuleSplitStyle

val ScalaVersion = "3.3.0"

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
    name := "budoux4s",
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
    // useYarn := true,
    scalaJSUseMainModuleInitializer := true,
    Compile / npmDependencies ++= Seq(
      "budoux" -> "0.5.2" // budoux has built-in TypeScript type definitions
    ),
    scalaJSLinkerConfig ~= (_.withModuleSplitStyle(
      ModuleSplitStyle.SmallModulesFor(List("io.github.windymelt.budoux4s"))
    )),
    stOutputPackage := "io.github.windymelt.budouxs.internal"
  )
