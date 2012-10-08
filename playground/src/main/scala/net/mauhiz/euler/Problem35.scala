package net.mauhiz.euler

import scala.collection.mutable
import net.mauhiz.util.Rotation
import net.mauhiz.util.prime.EratosthenesSiede
import net.mauhiz.util.prime.MillerRabin
import net.mauhiz.util.prime.VeryLuckyPrimeTester

object Problem35 extends App {

	def rotateInt(n: Int): Seq[Int] = {
		val acc = new mutable.HashSet[Int]
		(1 to n).foreach { Rotation.rotate(n.toString, _).foreach { acc += _.toInt } }
		acc.toSeq
	}

	def checkCyclicPrime(i: Int): Boolean = {
		!rotateInt(i).exists {
			!new MillerRabin(20, new VeryLuckyPrimeTester()).isPrime(_)
		}
	}

	def sol(max: Int) = (1 to max).filter { checkCyclicPrime }.size
	println(sol(1000000))
}