package net.mauhiz.euler

import scala.annotation.switch
import scala.annotation.tailrec

object Problem33 extends App {

	def tupleProduct(n: (Int, Int), d: (Int, Int)): (Int, Int) = (n._1 * d._1, n._2 * d._2)

	@tailrec
	def gcd(n: Int, d: Int): Int = {
		d match {
			case 0 ⇒ n
			case _ ⇒ gcd(d, n % d)
		}
	}

	val p = rs.reduceLeft(tupleProduct)

	val rs = for (
		i ← 1 to 9; j ← (i + 1) to 9; k ← 1 to 9;
		if k * (9 * i + j) == 10 * i * j
	) yield (10 * i + j, 10 * j + k)

	println(p._2 / gcd(p._1, p._2))
}