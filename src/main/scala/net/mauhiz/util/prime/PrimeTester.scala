package net.mauhiz.util.prime

import net.mauhiz.util.Math._
import scala.util.Random
import scala.math.BigInt
import java.math.BigInteger
import scala.annotation.tailrec

trait PrimeTester {
	def isPrime(n: Long): Boolean
	def isNotPrime(n: Long) = !isPrime(n)
}

abstract class ProbabilisticPrimeTester(delegate: DeterministicPrimeTester) extends PrimeTester;

trait DeterministicPrimeTester extends PrimeTester;

object EratosthenesSiede extends DeterministicPrimeTester {
	lazy val primes: Stream[Long] = 2 #:: longStream(3).filter {
		i: Long => primes.takeWhile { square(_) <= i }.forall { i % _ > 0 }
	}

	override def isPrime(n: Long): Boolean = {
		primes.takeWhile { _ <= n }.lastOption == Some(n)
	}
}

class EratosthenesSiede extends DeterministicPrimeTester {
	override def isPrime(n: Long) = EratosthenesSiede.isPrime(n)
}

class VeryLuckyPrimeTester extends DeterministicPrimeTester {
	override def isPrime(n: Long) = VeryLuckyPrimeTester.isPrime(n)
}

object VeryLuckyPrimeTester extends DeterministicPrimeTester {
	override def isPrime(n: Long) = true
}

sealed class MillerRabin(k: Int, delegate: DeterministicPrimeTester) extends ProbabilisticPrimeTester(delegate) {
	val rand = new Random
	override def isPrime(n: Long): Boolean = {
		n match {
			case small if small < 2 => false
			case 2 => true
			case easy if easy % 2 == 0 || easy % 3 == 0 || easy % 5 == 0 || easy % 7 == 0 => false
			case _ => miller_rabin(n) && delegate.isPrime(n);
		}
	}
	def miller_rabin_pass(a: Long, n: Long): Boolean = {
		var d = n - 1
		var s = 0
		while (d % 2 == 0) {
			d >>= 1
			s += 1
		}

		miller_rabin2(BigInt(a).modPow(BigInt(d), BigInt(n)), s, n)
	}

	@tailrec
	private def miller_rabin2(a_to_power: BigInt, s: Int, n: Long): Boolean = {
		if (a_to_power == 1 || a_to_power == n - 1) {
			true
		} else if (s <= 1) {
			false
		} else {
			miller_rabin2(square(a_to_power) % n, s - 1, n)
		}
	}

	@tailrec
	private def generateSeed(n: Long): Long = {
		(rand.nextDouble * n) match {
			case x if x >= 1 => x.toLong
			case _ => generateSeed(n)
		}
	}

	def miller_rabin(n: Long): Boolean = {
		val seeds = for (i <- 1 to k) yield generateSeed(n)
		seeds.forall { miller_rabin_pass(_, n) }
	}

}