package net.mauhiz.euler

import scala.io.Source
import net.mauhiz.util.prime.EratosthenesSiede
import net.mauhiz.util.Syntax._

object Problem43 extends App {
	val sevenPrimes = EratosthenesSiede.primes.take(7)
	def hasNiceProperty(pand: String): Boolean = {
		sevenPrimes.zipWithIndex.reverse.forall {
			case (prime, index) => pand.slice(index + 1, index + 4).toInt % prime == 0
		}
	}

	printTime {
		println(('0' to '9').mkString.permutations.filter { hasNiceProperty }.map { _.toLong }.sum)
	}
}