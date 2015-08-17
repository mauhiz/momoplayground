package net.mauhiz.euler

object Problem29 extends App {
	def sol(max: Int): Int = {
		val rang = 2 to max
		val d = for (a <- rang; b <- rang) yield BigInt(a).pow(b)
		d.distinct.size
	}

	println(sol(100))
}