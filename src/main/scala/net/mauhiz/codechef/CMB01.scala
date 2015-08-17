package net.mauhiz.codechef

import scala.io.StdIn

object CMB01 extends App {
	val T = StdIn.readLine.toInt
	for (_ <- 1 to T) {
		val inputs = StdIn.readLine.split(" ")
		println(cmb01(inputs))
	}

	// reversed sum of reversed inputs
	def cmb01(inputs: Array[String]): String = {
		val reversedInputs = inputs.map { _.reverse.toInt }
		reversedInputs.sum.toString.reverse
	}
}