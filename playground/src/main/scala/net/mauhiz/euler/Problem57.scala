package net.mauhiz.euler

import net.mauhiz.util.Math._
import net.mauhiz.util.Syntax._
import scala.math.BigInt

object Problem57 extends App {

	class SqrtIterator(limit: Int) extends Iterator[Tuple2[BigInt, BigInt]] {
		var frac = (BigInt(2), BigInt(3))
		var count = 0
		def hasNext = count < limit

		def next: Tuple2[BigInt, BigInt] = {
			frac = (2 * frac._2 + frac._1, frac._2 + frac._1)
			count += 1
			frac
		}
	}

	def isOk(frac: Tuple2[BigInt, BigInt]) = {
		frac._1.toString.size > frac._2.toString.size
	}

	def find(limit: Int) = {
		new SqrtIterator(limit).filter { isOk }.size
	}

	printTime {
		println(find(1000))
	}

}