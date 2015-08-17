package net.mauhiz.euler

import net.mauhiz.util.Math.Digit
import net.mauhiz.util.Math.Pandigital
import net.mauhiz.util.Math.fibonacci
import net.mauhiz.util.Syntax.time

object Problem104 extends App {
	def firstAndLastPan9(b: BigInt): Boolean = {
		if (Pandigital.isPandigital(9)(Digit.lastDigits(9)(b))) {
			Pandigital.isStrPandigital(9)(b.toString.slice(0, 9))
		} else {
			false
		}
	}

	def p104: Int = {
		lazy val bigfibs = fibonacci.zipWithIndex.drop(2749)
		lazy val skipNonP9 = bigfibs.dropWhile { case (bigfib, _) => !firstAndLastPan9(bigfib) }
		skipNonP9(0)._2
	}

	time {
		println(p104)
	}
}