package net.mauhiz.euler

import net.mauhiz.util.Syntax._

object Problem23 extends App {
	def sumOfDivisors(n: Int): Int = {
		val divisors = for (i ← 1 until n if n % i == 0) yield i
		divisors.sum
	}
	def isAbundant(n: Int): Boolean = sumOfDivisors(n) > n

	def p23(upperBound: Int) = {
		val allAbundants = for (i ← 0 to upperBound if isAbundant(i)) yield i

		val exc = allAbundants.flatMap {
			a: Int ⇒
				allAbundants.takeWhile { _ <= (upperBound - a) }.map { a + _ }
		}

		((1 to upperBound) diff exc).sum
	}
	println(p23(28123))

}