package net.mauhiz.euler

import net.mauhiz.util.Syntax._

object Problem23 extends App {
	def sumOfDivisors(n: Int): Int = (1 until n).filter(n % _ == 0).sum
	def isAbundant(n: Int): Boolean = sumOfDivisors(n) > n

	val upperBound = 28123
	lazy val allAbundants = (0 to upperBound).filter(isAbundant)

	lazy val exc = allAbundants.view.flatMap { a ⇒
		allAbundants.takeWhile(_ <= (upperBound - a)).map(a +)
	}

	time {
		println(((1 to upperBound) diff exc).sum)
	}
}