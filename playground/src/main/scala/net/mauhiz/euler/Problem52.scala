package net.mauhiz.euler

import net.mauhiz.util.Math._
import net.mauhiz.util.Permutation

object Problem52 extends App {
	def generateTargets(n: Long): Seq[Long] = Seq(2 * n, 3 * n, 4 * n, 5 * n, 6 * n)

	def getDigits(n: Long): Seq[Char] = n.toString

	lazy val valid = longStream(1).map {
		n: Long ⇒ (n, generateTargets(n))
	}.filter {
		tuple: (Long, Seq[Long]) ⇒
			val digits = Permutation.mapOccurences(getDigits(tuple._1))
			!tuple._2.exists {
				p: Long ⇒ !(digits equals Permutation.mapOccurences(getDigits(p)))
			}
	}.map {
		tuple: (Long, Seq[Long]) ⇒ tuple._1
	}

	println(valid.head)
}