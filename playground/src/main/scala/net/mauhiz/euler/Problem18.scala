package net.mauhiz.euler

import scala.annotation.tailrec
import scala.math.Numeric
import math.Numeric.Implicits._

object Problem18 extends App {
	val s = """75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
		"""

	def toGrid(s: String) = {
		val lines = s.trim.split("\n").toIndexedSeq
		lines.map {
			_.split("\\s+").map { _.toInt }.toIndexedSeq
		}
	}

	def tupleSum(t: Tuple2[Int, Int]) = t._1 + t._2
	def tupleMax(t: Tuple2[Int, Int]) = t._1 max t._2

	def f(grid: IndexedSeq[IndexedSeq[Int]]): Int = {
		@tailrec
		def f(rows: IndexedSeq[IndexedSeq[Int]], bottom: IndexedSeq[Int]): Int = {
			val ms = bottom.zip(bottom.tail).map { tupleMax }

			val lastRow = rows.last
			val ss = lastRow.zip(ms).map { tupleSum }
			ss match {
				case x if x.size == 1 ⇒ ss.head
				case _ ⇒ f(rows.init, ss)
			}
		}
		f(grid.init, grid.last)
	}

	println(f(toGrid(s)))
}