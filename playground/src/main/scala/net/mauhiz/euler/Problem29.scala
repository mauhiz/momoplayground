package net.mauhiz.euler

object Problem29 extends App {
  val d = (2 to 100).flatMap {
    a: Int ⇒
      (2 to 100)
        .map {
          b: Int ⇒
            BigInt(a).pow(b)
        }
  }.distinct
  println(d.size)
}