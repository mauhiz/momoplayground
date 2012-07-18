package net.mauhiz.util

object Palindrome {
  def is[A](s: Seq[A]): Boolean = {
    val middle = s.length / 2
    s.take(middle) == s.takeRight(middle).reverse
  }
}