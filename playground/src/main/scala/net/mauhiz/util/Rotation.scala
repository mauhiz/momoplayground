package net.mauhiz.util

import scala.collection.generic.CanBuildFrom

object Rotation {

  def rotate[A, C](coll: C, number: Int)(implicit c2i: C ⇒ Iterable[A], cbf: CanBuildFrom[C, A, C]): Option[C] = {
    if (coll.hasDefiniteSize) {
      val positions = number % coll.size match {
        case i if i < 0 ⇒ i + coll.size
        case i ⇒ i
      }
      val builder = cbf()
      builder ++= coll.drop(positions)
      builder ++= coll.take(positions)
      Some(builder.result())
    } else {
      None
    }
  }
}