package net.mauhiz.euler

import net.mauhiz.util.Math._

object Problem27 extends App {

  val ns = (-999 until 1000).flatMap { a ⇒
    (-999 until 1000).map(b ⇒ (a, b, (0 to 1000).view
      .takeWhile(n ⇒ EratosthenesSiede.isPrime(n * n + a * n + b)).size))
  }

  val t = ns.reduceLeft((a, b) ⇒ if (a._3 > b._3) a else b)

  println(t._1 * t._2)
}