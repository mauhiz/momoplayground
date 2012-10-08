package net.mauhiz.codechef

import net.mauhiz.util.Math.factorial

object FCTRL2 extends App {

	val T = readLine.toInt
	for (_ ← 1 to T) {
		println(factorial(readLine.toInt))
	}
}