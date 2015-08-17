package net.mauhiz.codechef

import net.mauhiz.util.Math.factorial
import scala.io.StdIn

object FCTRL2 extends App {

	val T = StdIn.readLine.toInt
	for (_ <- 1 to T) {
		println(factorial(StdIn.readLine.toInt))
	}
}