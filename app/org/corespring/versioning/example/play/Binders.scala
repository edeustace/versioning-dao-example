package org.corespring.versioning.example.play

import play.api.mvc.PathBindable
import org.bson.types.ObjectId
import org.corespring.platform.data.mongo.models.VersionedId

object Binders {

  implicit def versionedIdPathBindable = new PathBindable[VersionedId[ObjectId]] {
    def bind(key: String, value: String) = if (value.contains(":")) {
      val arr = value.split(":")
      val id = arr(0)
      val v = arr(1)
      vId(key, id, int(v))
    } else {
      vId(key, value)
    }

    private def vId(key: String, id: String, v: Option[Int] = None) = if (ObjectId.isValid(id)) {
      Right(VersionedId(new ObjectId(id), v))
    }
    else {
      Left("Invalid object id for key " + key)
    }


    private def int(i: String): Option[Int] = try {
      Some(i.toInt)
    } catch {
      case _: Throwable => None
    }

    def unbind(key: String, value: VersionedId[ObjectId]) = value.version.map(value.id.toString + ":" + _).getOrElse(value.toString)
  }

}
