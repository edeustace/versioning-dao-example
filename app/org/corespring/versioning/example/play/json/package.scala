package org.corespring.versioning.example.play

import org.corespring.versioning.example.models.Item
import play.api.libs.json._

package object json {

  implicit object ItemWrites extends Writes[Item] {

    def writes(item: Item): JsValue = {
      JsObject(
        Seq(
          "id" -> JsObject(
            Seq( "id" -> JsString(item.id.id.toString) ) ++ item.id.version.map( "version" -> JsNumber(_))

          ),
          "title" -> JsString(item.title)
        )
      )
    }
  }
}
