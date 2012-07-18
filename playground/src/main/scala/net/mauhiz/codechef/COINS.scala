package net.mauhiz.codechef

import scala.MathCommon

object COINS extends App {
  def maxDollars(n: Long): Long = {
    n match {
      case 0 ⇒ 0
      case _ ⇒ n.max(maxDollars(n / 2) + maxDollars(n / 3) + maxDollars(n / 4))
    }
  }

  while (true) {
    println(maxDollars(readLine.toLong))
  }
}