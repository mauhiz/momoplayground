package net.mauhiz.euler

import net.mauhiz.util.{ Truncation }
import net.mauhiz.util.Math._
import net.mauhiz.util.prime.EratosthenesSiede

object Problem37 extends App {

	def isTruncatablePrime(i: Long): Boolean = {
		EratosthenesSiede.isPrime(i) && !Truncation.generateDistinctTruncations(i.toString).exists {
			s: Seq[Char] =>
				!EratosthenesSiede.isPrime(s.mkString.toLong)
		}
	}

	def sumTruncatablePrimes: Long = {
		val noSingleDigitPrimes = EratosthenesSiede.primes.filter { _ >= 10 }
		val truncatablePrimes = noSingleDigitPrimes.filter { isTruncatablePrime }
		truncatablePrimes.take(11).sum
	}

	println("sum: " + sumTruncatablePrimes)
	// println(List(2, 3, 5, 7, 23, 37, 53, 73, 313, 317, 373, 797, 3137, 3797, 739397).filter(_ >= 10).sum)
}