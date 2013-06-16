import sbt._
import Keys._
import sbt.PlayProject._

object ApplicationBuild extends Build {

  val appName = "versioning-dao-example"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "org.corespring" %% "salat-versioning-dao" % "0.1-SNAPSHOT",
    "se.radley" %% "play-plugins-salat" % "1.1"
  )


  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    resolvers += Resolver.file("local ivy", file(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns),
    routesImport ++= Seq("se.radley.plugin.salat.Binders._",
      "org.corespring.platform.data.mongo.models.VersionedId",
      "org.bson.types.ObjectId",
      "org.corespring.versioning.example.play.Binders._")
  )

}
