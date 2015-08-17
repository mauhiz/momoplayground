package net.mauhiz.euler

import net.mauhiz.util.Math.Polygone._

object Problem45 extends App {
	lazy val tphs = hexagones.filter { n:Long => isTriangle(n) && isPentagone(n) }
	assert(tphs.takeWhile { _ <= 40755 }.last == 40755)
	println(tphs.filter { _ > 40755 }.head)
}