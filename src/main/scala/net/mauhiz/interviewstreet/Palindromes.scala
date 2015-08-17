package net.mauhiz.interviewstreet

package palindromes {

import scala.io.StdIn
	object Solution extends App {
		val T = StdIn.readLine.toInt

		(1 to T).foreach {
			_ => println(expectedSwaps(StdIn.readLine).formatted("%.4f"))
		}
		def expectedSwaps(in: String): Double = {
			throw new Exception("Todo")
		}
	}
}
