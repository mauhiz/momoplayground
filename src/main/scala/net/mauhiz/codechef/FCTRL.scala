package net.mauhiz.codechef

import scala.io.StdIn

object FCTRL extends App {
	def addToZ(x: Int): Int = x + Z(x)

	def Z(k: Int): Int = {
		k match {
			case k if (k < 5) => 0
			case _ => addToZ(k / 5)
		}
	}

	val T = StdIn.readLine.toInt
	for (_ <- 1 to T) {
		println(Z(StdIn.readLine.toInt))
	}
}