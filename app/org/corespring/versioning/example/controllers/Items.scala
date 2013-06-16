package org.corespring.versioning.example.controllers

import play.api.mvc.{Action, Controller}
import org.corespring.platform.data.mongo.models.VersionedId
import org.bson.types.ObjectId
import org.corespring.versioning.example.services.ItemService
import play.api.libs.json.Json

class Items extends Controller{


  def get(id:VersionedId[ObjectId]) = Action{
    request => {
      import org.corespring.versioning.example.play.json._
      Ok(Json.toJson(ItemService.get(id)))
    }
  }

}

object Items extends Items
