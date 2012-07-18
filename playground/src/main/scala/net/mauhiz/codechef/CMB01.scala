package net.mauhiz.codechef

object CMB01 extends App {
  val cases = 1 to readLine.toInt
  cases.foreach {
    i: Int ⇒
      val inputs = readLine.split(" ")
      val reversedInputs = inputs.map(_ reverse)
      val sumOfReversedInputs = reversedInputs.map(_ toInt).foldLeft(0)(_ + _)
      val r = sumOfReversedInputs.toString.reverse
      println(r)
  }
}