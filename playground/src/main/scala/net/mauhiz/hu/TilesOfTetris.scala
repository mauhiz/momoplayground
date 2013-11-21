package net.mauhiz.hu

import net.mauhiz.util.Math._

object TilesOfTetris extends App {
	val lines = Iterator.continually(readLine).takeWhile { line: String => line != "0 0" }
	lines.foreach {
		line =>
			val input = line.trim.split(" ")
			val W = input(0).toInt
			val H = input(1).toInt
			println(squareIt(W, H))
	}

	/* The number of of tiles to use to make a square (same orientation) */
	def squareIt(W: Int, H: Int): Int = square(lcm(W, H)) / (W * H)
}