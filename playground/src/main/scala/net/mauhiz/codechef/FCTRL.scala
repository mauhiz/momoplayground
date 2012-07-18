package net.mauhiz.codechef

object FCTRL extends App {
  def addToZ(x: Int): Int = x + Z(x)

  def Z(k: Int): Int = {
    k match {
      case k if (k < 5) ⇒ 0
      case _ ⇒ addToZ(k / 5)
    }
  }

  (1 to readLine.toInt).foreach {
    i: Int ⇒
      println(Z(readLine.toInt))
  }
}