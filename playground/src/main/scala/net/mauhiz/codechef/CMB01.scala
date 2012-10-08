package net.mauhiz.codechef

object CMB01 extends App {
	val T = readLine.toInt
	for (_ ← 1 to T) {
		val inputs = readLine.split(" ")
		println(cmb01(inputs))
	}

	// reversered sum of reversed inputs
	def cmb01(inputs: Array[String]): String = {
		val reversedInputs = inputs.map { _.reverse.toInt }
		reversedInputs.sum.toString.reverse
	}
}