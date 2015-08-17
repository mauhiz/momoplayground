package net.mauhiz.praxis

object CountingOnes extends App {

	def countOnes(n: Int): Int = {
		n.toString.count(_ == '1')
	}

	def countOnesStream: Stream[Int] = {
		Stream.from(1).map(countOnes)
	}

	def countOnesRange(n: Int): Int = {
		countOnesStream.take(n).sum
	}

	def largestIdentity: Int = {
		Stream.from(2).filter { n: Int =>
			countOnesRange(n) == n
		}.head
	}

	println(countOnesRange(13))
	println(largestIdentity)
}