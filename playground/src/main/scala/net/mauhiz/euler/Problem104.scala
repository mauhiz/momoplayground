package net.mauhiz.euler

import net.mauhiz.util.Syntax._
import net.mauhiz.util.Math._

object Problem104 extends App {
	def firstAndLastPan9(b: BigInt): Boolean = {
		if (Pandigital.isPandigital(9)(Digit.lastDigits(9)(b))) {
			Pandigital.isStrPandigital(9)(b.toString.slice(0, 9))
		} else {
			false
		}
	}

	lazy val bigfibs = fibonacci.zipWithIndex.drop(2749)
	lazy val skipNonP9 = bigfibs.dropWhile { tuple ⇒ !firstAndLastPan9(tuple._1) }
	lazy val k = skipNonP9.apply(0)._2

	time {
		println(k)
	}
}