package net.mauhiz.euler

import net.mauhiz.util.Math._
import net.mauhiz.util.prime.EratosthenesSiede

object Problem46 extends App {
	def isNotStern(n: Long): Boolean = {
		val smallerPrimes = EratosthenesSiede.primes.takeWhile { _ < n }
		smallerPrimes.exists {
			p: Long => isWhole(math.sqrt((n - p) / 2d))
		}
	}

	def isStern(n: Long) = !isNotStern(n)

	lazy val oddComposites = oddStream(3).filter { EratosthenesSiede.isNotPrime }

	assert(isNotStern(33))
	assert(isStern(5777))

	println(oddComposites.filter { isStern }.head)
}