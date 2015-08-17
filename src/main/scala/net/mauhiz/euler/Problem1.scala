package net.mauhiz.euler

import net.mauhiz.util.Syntax._

object Problem1 extends App {

	// ART: 1.70ms
	def sol1(max: Int): Int = {
		val a = for (x <- 1 until max if x % 3 == 0 || x % 5 == 0) yield x
		a.sum
	}
	println(sol1(1000))
}