package net.mauhiz.codechef

import net.mauhiz.util.Palindrome
import scala.io.StdIn

object DPC206 extends App {

	def doubleUntilPalindrome(input: String): (Int, String) = {

		def doubleUntilPalindrome(state: (Int, String)): (Int, String) = {
			state._2 match {
				case s if Palindrome.is(s) => state
				case _ => doubleUntilPalindrome(state._1 + 1, double(state._2))
			}
		}

		doubleUntilPalindrome(0, input)
	}

	def double(s: String): String = (s.toLong + s.reverse.toLong).toString

	val T = StdIn.readLine.toInt
	for (_ <- 1 to T) {
		val pal = doubleUntilPalindrome(StdIn.readLine)
		println(pal._1 + " " + pal._2)
	}
}