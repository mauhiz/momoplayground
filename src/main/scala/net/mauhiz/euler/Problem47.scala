package net.mauhiz.euler

import scala.io.Source
import net.mauhiz.util.prime.EratosthenesSiede
import net.mauhiz.util.Syntax._
import scala.collection.mutable.Builder
import net.mauhiz.util.Math

// 134043
object Problem47 extends App {
	def fact(n: Long, l: Builder[Long, List[Long]] = List.newBuilder[Long]): List[Long] = {
		if (EratosthenesSiede.primes.dropWhile { _ < n }.head == n) {
			l += n
			l.result
		} else {
			val x = EratosthenesSiede.primes.filter { f => n % f == 0 && f < n }.head
			l += x
			fact(n / x, l)
		}
	}

	def dist4(n: Long): Boolean = {
		fact(n).distinct.size == 4 &&
			fact(n + 1).distinct.size == 4 &&
			fact(n + 2).distinct.size == 4 &&
			fact(n + 3).distinct.size == 4
	}

	printTime {
		println(Math.longs.drop(EratosthenesSiede.primes.take(4).map { _.toInt }.foldLeft(1) { _ * _ }).dropWhile { !dist4(_) }(1))
	}
}