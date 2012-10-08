package net.mauhiz.euler

import net.mauhiz.util.Math

object Problem32 extends App {
	def sol1(max: Int) = {
		val products = for {
			a ← 2 to max
			b ← 2 to max / a
			product = a * b
			if Math.Pandigital.isStrPandigital(9)(a.toString + b.toString + product.toString)
		} yield product
		products.distinct.sum
	}

	println(sol1(10000))

}