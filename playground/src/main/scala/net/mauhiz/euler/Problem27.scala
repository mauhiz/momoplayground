package net.mauhiz.euler

import net.mauhiz.util.Math.square
import net.mauhiz.util.prime.EratosthenesSiede

object Problem27 extends App {

	def sol1(x: Int): Int = {
		def quadraticIsPrime(a: Int, b: Int)(n: Int) = EratosthenesSiede.isPrime(square(n) + a * n + b)
		val rang = (1 - x) until x
		val quads = for (a ← rang; b ← rang) yield {
			(a, b, (0 to x).takeWhile { quadraticIsPrime(a, b) }.size)
		}

		val bestQuad = quads.maxBy { case (a, b, s) ⇒ s }
		bestQuad._1 * bestQuad._2
	}
	println(sol1(1000))
}