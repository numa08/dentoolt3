import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "numadio"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      

	    libraryDependencies += "org.twitter4j" % "twitter4j-core" % "3.0.3"

    )

}
