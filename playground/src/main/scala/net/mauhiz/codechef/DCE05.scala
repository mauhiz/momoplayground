package net.mauhiz.codechef

object DCE05 extends App {
  def subPow2(n: Int): Int = {
    n match {
      case 0 ⇒ 0
      case 1 ⇒ 1
      case _ ⇒ 2 * subPow2(n / 2)
    }
  }

  (1 to readLine.toInt).foreach {
    i: Int ⇒
      println(subPow2(readLine.toInt))
  }
}