package net.mauhiz.interviewstreet

package palindromes {
	object Solution extends App {
		val T = readLine.toInt

		(1 to T).foreach {
			_ => println(expectedSwaps(readLine).formatted("%.4f"))
		}
		def expectedSwaps(in: String): Double = {
			throw new Exception("Todo")
		}
	}
}
