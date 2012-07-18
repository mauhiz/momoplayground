package net.mauhiz.util

object Palindrome {
	def is[A](s: Seq[A]): Boolean = s.take(s.length / 2) == s.takeRight(s.length / 2).reverse
}