package net.mauhiz.codechef

import scala.io.StdIn

object DCE05 extends App {
	def subPow2(n: Int): Int = {
		n match {
			case 0 => 0
			case 1 => 1
			case _ => 2 * subPow2(n / 2)
		}
	}

	val T = StdIn.readLine.toInt
	for (_ <- 1 to T) {
		println(subPow2(StdIn.readLine.toInt))
	}
}