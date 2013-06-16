package org.corespring.versioning.example

import _root_.play.api.Application
import _root_.play.api.GlobalSettings
import org.bson.types.ObjectId
import org.corespring.platform.data.mongo.models.VersionedId
import org.corespring.versioning.example.models.Item
import org.corespring.versioning.example.services.ItemService

object Global extends GlobalSettings {

  override def onStart(app: Application) = {

    println("... on start ...")
    val id = ObjectId.get()
    println(" id is: " + id)

    ItemService.save(Item(VersionedId(id), title = "version 0"))
    ItemService.save(Item(VersionedId(id), title = "version 1"))
    ItemService.save(Item(VersionedId(id), title = "version 2"))
    ItemService.save(Item(VersionedId(id), title = "version 3"))
    ItemService.save(Item(VersionedId(id), title = "version 4"))
    ItemService.save(Item(VersionedId(id), title = "version 5"))
    ItemService.save(Item(VersionedId(id), title = "version 6"))
    ItemService.save(Item(VersionedId(id), title = "version 7"))
  }

}
