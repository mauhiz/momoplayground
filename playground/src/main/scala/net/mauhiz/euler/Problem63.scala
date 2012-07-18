package net.mauhiz.euler

import net.mauhiz.util.Syntax._

object Problem63 extends App {
	lazy val r = (1 until 10).map { n: Int ⇒ (1 / (1 - math.log10(n))).toInt }.sum

	time {
		println(r)
	}
}