package org.corespring.versioning.example.services

import org.bson.types.ObjectId
import org.corespring.platform.data.mongo.models.VersionedId
import org.corespring.versioning.example.models.Item
import org.corespring.versioning.example.dao.ItemDao

trait ItemService {

  def get(id:VersionedId[ObjectId]) : Option[Item]
}

object ItemService extends ItemService{

  def get(id:VersionedId[ObjectId]) : Option[Item] = ItemDao.get(id)

  def save(item:Item) {
    ItemDao.save(item, true)
  }
}
