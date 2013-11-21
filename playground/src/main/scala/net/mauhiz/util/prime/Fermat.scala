package net.mauhiz.util.prime

import scala.util.Random

import net.mauhiz.util.Math.square

case class FermatPrimalityTester(rounds: Int, delegateTester: DeterministicPrimeTester) extends ProbabilisticPrimeTester(delegateTester) {
	private val random = new Random
	override def isPrime(n: Long): Boolean = {
		n match {
			case big if big > Int.MaxValue ⇒ delegateTester.isPrime(n)
			case _ ⇒ isPrime(n.asInstanceOf[Int]) && delegateTester.isPrime(n)
		}
	}

	def isPrime(subject: Int): Boolean = {
		val testing = getRandomIntegers(subject)
		testing.forall { modExp(_, subject - 1, subject) == 1 }
	}

	private def getRandomIntegers(subject: Int): IndexedSeq[Int] = {
		(0 until rounds).map { _ ⇒ 1 + random.nextInt(subject - 1) }
	}

	private def modExp(base: Long, exponent: Long, modulus: Long): Long = {
		exponent match {
			case 0 ⇒ 1
			case _ ⇒ {
				val z = modExp(base, exponent / 2, modulus)

				exponent % 2 match {
					case 0 ⇒ square(z) % modulus
					case _ ⇒ base * square(z) % modulus
				}
			}
		}
	}
}