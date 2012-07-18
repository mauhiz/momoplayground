package net.mauhiz.euler

import scala.io.Source

object Problem42 extends App {
	lazy val words = Source.fromURL("http://projecteuler.net/project/words.txt").mkString.split(",").map { removeExtremities(_) }

	lazy val triangularNumbers = Stream.from(0).map { n: Int ⇒ n * (n + 1) / 2 }

	def removeExtremities[A](l: Seq[A]): Seq[A] = l.slice(1, l.size - 1)

	def charValue(c: Char): Int = c - 'A' + 1

	def wordValue(s: Seq[Char]): Int = s.map { charValue }.sum

	def isTriangleWord(s: Seq[Char]): Boolean = {
		val wv = wordValue(s)
		triangularNumbers.takeWhile(_ <= wv).last == wv
	}

	assert(isTriangleWord("SKY"))
	
	println(words.filter(isTriangleWord).size)

}