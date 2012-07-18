package net.mauhiz.euler

import net.mauhiz.util.Math._
import net.mauhiz.util.Syntax._

object Problem53 extends App {
	def C(n: Int)(r: Int): BigInt = {
		factorial(n) / (factorial(r) * factorial(n - r))
	}

	lazy val tuples = for (r ← 1 to 100; n ← r to 100) yield (r, n)

	lazy val combinations = tuples.map {
		case (r, n) ⇒ C(n)(r)
	}
	lazy val bigones = combinations.filter {
		_ > 1000000
	}

	time {
		println(bigones.size)
	}

}