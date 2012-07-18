package net.mauhiz.euler

import net.mauhiz.util.Math._

object Problem40 extends App {
	lazy val numStream: Stream[Int] = Stream.from(0).map { _ toString }.flatten.map { Digit.digitToInt }

	assert(numStream(12) == 1)

	println(numStream(1) * numStream(10) * numStream(100) * numStream(1000) * numStream(10000) * numStream(100000) * numStream(1000000))
}