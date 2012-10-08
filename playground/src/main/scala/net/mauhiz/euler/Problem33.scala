package net.mauhiz.euler

import net.mauhiz.util.Math

object Problem33 extends App {

	def tupleProduct(n: (Int, Int), d: (Int, Int)): (Int, Int) = (n._1 * d._1, n._2 * d._2)

	def sol = {

		val rs = for {
			i ← 1 to 9
			j ← (i + 1) to 9
			k ← 1 to 9
			if k * (9 * i + j) == 10 * i * j
		} yield (10 * i + j, 10 * j + k)

		val p = rs.reduceLeft { tupleProduct }

		p._2 / Math.gcd(p._1, p._2)
	}

	println(sol)
}