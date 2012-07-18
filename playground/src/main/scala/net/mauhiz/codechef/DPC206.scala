package net.mauhiz.codechef

import net.mauhiz.util.Palindrome

object DPC206 extends App {

  def doubleUntilPalindrome(input: String): (Int, String) = doubleUntilPalindrome(0, input)

  def doubleUntilPalindrome(state: (Int, String)): (Int, String) = {
    state._2 match {
      case s if Palindrome.is(s) ⇒ state
      case _ ⇒ doubleUntilPalindrome(state._1 + 1, double(state._2))
    }
  }

  def double(s: String): String = (s.toLong + s.reverse.toLong).toString

  (1 to readLine.toInt).foreach {
    i: Int ⇒
      val pal = doubleUntilPalindrome(readLine)
      println(pal._1 + " " + pal._2)
  }
}