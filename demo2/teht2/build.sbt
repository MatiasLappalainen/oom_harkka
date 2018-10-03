import java.nio.file.{Files, Path}

// Project name
name := "oom-oomkit-demo"

// organization name
organization := "fi.utu"

version := "1.0"

// project description
description := "OOMkit example applications"

val javaVersion = 10

javaVersion match {
    case 7 => javacOptions in (Compile, compile) ++= Seq("-source", "1.7", "-target", "1.7")
    case 8 => javacOptions in (Compile, compile) ++= Seq("-source", "1.8", "-target", "1.8")
    case 10 => javacOptions in (Compile, compile) ++= Seq("-source", "10", "-target", "10")
    case 11 => javacOptions in (Compile, compile) ++= Seq("-source", "11", "-target", "11")
    case _ => throw new Exception("Unsupported version")
}

compileOrder := CompileOrder.JavaThenScala

// Enables publishing to maven repo
publishMavenStyle := true

// Do not append Scala versions to the generated artifacts
crossPaths := false

// This forbids including Scala related libraries into the dependency
autoScalaLibrary := false

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

libraryDependencies += "fi.utu" % "oom-oomkit" % "1.0"

//// JQWIK / JUNIT configuration
  
// library dependencies. (orginization name) % (project name) % (version)
// jqwik 0.8.15 still depends on old junit
libraryDependencies ++= Seq(
    "org.junit.platform" % "junit-platform-commons"         % "1.2.0",
    "org.junit.platform" % "junit-platform-runner"          % "1.2.0",
    "org.junit.jupiter"  % "junit-jupiter-engine"           % "5.2.0",
    "org.junit.jupiter"  % "junit-jupiter-api"              % "5.2.0",
    "org.junit.jupiter"  % "junit-jupiter-migrationsupport" % "5.2.0",
    "org.junit.jupiter"  % "junit-jupiter-params"           % "5.2.0",
    "net.jqwik"          % "jqwik"                          % "0.8.15"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-c")


//// COFOJA configuration

fork in Global := true
val contractDir = Def.taskKey[Path]("Cofoja contract directory")
contractDir := {
  val dir = file("contracts/").toPath
  if (!Files.exists(dir)) Files.createDirectory(dir)
  dir
}

// pick correct cofoja version (bytecode incompatibilities)
val cofoja = javaVersion match {
  case 10 | 11 => "org.huoc" % "cofoja" % "1.3.1.1" from "https://gitlab.utu.fi/jmjmak/cofoja/raw/5242caa53e271db3fcb890af1f42b61c2d60b42b/dist/cofoja+asm-1.3.1-20180914.jar?inline=false/cofoja+asm-1.3.1-20180914.jar"
  case _ =>
    "org.huoc" % "cofoja" % "1.3" from "https://github.com/nhatminhle/cofoja/releases/download/v1.3/cofoja.contracts.asm-1.3-20160207.jar"
    // if it fails, try this
    //"org.huoc" % "cofoja" % "1.3.1" from "http://central.maven.org/maven2/org/huoc/cofoja/1.3.1/cofoja-1.3.1.jar"
}

libraryDependencies += cofoja


val cofojaLocation = taskKey[Seq[String]]("Cofoja location.")
 cofojaLocation := {
   val dir = contractDir.value

//   (dependencyClasspath in Compile).value.filter{
//     _.metadata(moduleID.key).toString() == cofoja.pomOnly().toString()}.map{ _.data.toString }
   (dependencyClasspath in Compile).value.filter{
     _.data.toString().contains("cofoja")}.map{ _.data.toString }
 }
javacOptions in (Compile, compile) ++= Seq("-Acom.google.java.contract.classoutput="+contractDir.value) ++ cofojaLocation.value.map{ "-Acom.google.java.contract.classpath=" + _ }
javaOptions ++= cofojaLocation.value.map{ "-javaagent:" + _ }

unmanagedResourceDirectories in Compile += baseDirectory.value / "contracts"


//// JAVAFX configuration

val javafx_version = javaVersion match {
  case 7 => 7
  case 8 => 8
  // if it fails, try this
  // case 8 => 11
  case 10 | 11 => 11
  case _ => throw new Exception("Unsupported JavaFX version")
}

// Read from JAVAFX_HOME environment variable. Extract the SDK ( http://jdk.java.net/openjfx/ ) to JAVAFX_HOME
val javaFxHome = file(scala.sys.env("JAVAFX_HOME"))
val javaHomeDir = file(scala.sys.env("JAVA_HOME"))
val osName: SettingKey[String] = SettingKey[String]("osName")

osName := (System.getProperty("os.name") match {
    case name if name.startsWith("Linux") => "linux"
    case name if name.startsWith("Mac") => "mac"
    case name if name.startsWith("Windows") => "win"
    case _ => throw new Exception("Unknown platform!")
})

javafx_version match {
    case 7 =>
        // TODO
        Seq(unmanagedJars in Compile += Attributed.blank(file(javaHomeDir + "/jre/lib/jfxrt.jar")))
    case 8 =>
        Seq(
          libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.144-R12",
          unmanagedJars in Compile += Attributed.blank(file(javaHomeDir + "/jre/lib/ext/jfxrt.jar")),
        )
    case 11 =>
        Seq(
        // Read from JAVAFX_HOME environment variable. Extract the SDK ( http://jdk.java.net/openjfx/ ) to JAVAFX_HOME

        javaOptions ++= Seq("--module-path", (javaFxHome / "javafx-sdk-11" / "lib").toPath.toString, "--add-modules=javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web"),

        libraryDependencies ++= Seq(
            "org.openjfx" % "javafx-base" % "11-ea+25" classifier osName.value,
            "org.openjfx" % "javafx-controls" % "11-ea+25" classifier osName.value,
            "org.openjfx" % "javafx-fxml" % "11-ea+25" classifier osName.value,
            "org.openjfx" % "javafx-graphics" % "11-ea+25" classifier osName.value,
            "org.openjfx" % "javafx-media" % "11-ea+25" classifier osName.value,
            "org.openjfx" % "javafx-swing" % "11-ea+25" classifier osName.value,
            "org.openjfx" % "javafx-web" % "11-ea+25" classifier osName.value
        )
        )
}

