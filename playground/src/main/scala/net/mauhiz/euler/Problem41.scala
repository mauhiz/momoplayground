package net.mauhiz.euler

import net.mauhiz.util.Math._
import net.mauhiz.util.Syntax._

object Problem41 extends App {
	// shortcut :
	// no pandigital sized 8 or 9 is prime, because sum of digits for 8- or 9- pandigital numbers is divisible by 3

	def charRangeToInt(s: Seq[Char]) = s.mkString.toInt

	lazy val pan7Permutations = ('1' to '7').permutations.map { charRangeToInt }
	lazy val primePermutations = pan7Permutations.filter {
		EratosthenesSiede.isPrime(_)
	}

	time {

		println(primePermutations.max)
	}
}