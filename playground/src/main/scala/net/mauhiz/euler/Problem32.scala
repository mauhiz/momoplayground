package net.mauhiz.euler

import net.mauhiz.util.Math

object Problem32 extends App {
	val ms = for {
		a ← 2 to 10000; b ← 2 to 10000 / a
		m = a * b; s = a.toString + b + m
		if Math.Pandigital.isStrPandigital(9)(s)
	} yield m

	println(ms.distinct.sum)

}