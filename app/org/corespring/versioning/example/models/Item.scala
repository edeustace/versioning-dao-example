package org.corespring.versioning.example.models

import org.corespring.platform.data.mongo.models.{EntityWithVersionedId, VersionedId}
import org.bson.types.ObjectId

case class Item(id:VersionedId[ObjectId], title : String) extends EntityWithVersionedId[ObjectId]


