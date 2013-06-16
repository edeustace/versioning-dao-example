package org.corespring.versioning.example.dao

import org.corespring.platform.data.mongo.SalatVersioningDao
import org.corespring.versioning.example.models.Item
import com.novus.salat.Context
import com.mongodb.casbah.MongoDB
import se.radley.plugin.salat.SalatPlugin
import play.api.PlayException
import play.api.Play.current
import play.api.Application

object ItemDao extends SalatVersioningDao[Item] {

  def salatDb(sourceName: String = "default")(implicit app: Application): MongoDB = {
    app.plugin[SalatPlugin].map(_.db(sourceName)).getOrElse(throw PlayException("SalatPlugin is not " +
      "registered.", "You need to register the plugin with \"500:se.radley.plugin.salat.SalatPlugin\" in conf/play.plugins"))
  }

  protected def db = salatDb()

  protected implicit def entityManifest: Manifest[Item] = Manifest.classType(classOf[Item])

  protected def collectionName = "items"

  protected implicit def context: Context = org.corespring.platform.data.mongo.ctx

}
