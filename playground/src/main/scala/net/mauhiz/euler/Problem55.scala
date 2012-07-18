package net.mauhiz.euler

import net.mauhiz.util.Math
import net.mauhiz.util.Syntax._
import net.mauhiz.util.Palindrome
import scala.annotation.tailrec

object Problem55 extends App {
	val max_iterations = 50
	def reverse(n: BigInt) = BigInt(n.toString.reverse)
	def reverseAndAdd(n: BigInt) = n + reverse(n)

	@tailrec
	def isLychrel(n: BigInt, iter: Int = 0): Boolean = {
		lazy val firstIter = iter == 0
		if (!firstIter && Palindrome.is(n.toString)) {
			false
		} else if (iter >= max_iterations) {
			true
		} else {
			isLychrel(reverseAndAdd(n), iter + 1)
		}
	}

	time {
		println((1 to 10000).filter { n: Int ⇒ isLychrel(n) }.size)
	}
}