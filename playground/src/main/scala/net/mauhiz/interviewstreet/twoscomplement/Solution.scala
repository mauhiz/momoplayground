package net.mauhiz.interviewstreet.twoscomplement

import scala.annotation.tailrec

object Solution extends App {
	val T = readLine.toInt

	(1 to T).foreach {
		_ =>
			{
				val input = readLine.split(" ").map { _.toInt }
				println(countOnes32bBetween(input(0), input(1)))
			}
	}
	def countOnes32bBetween(a: Int, b: Int): Long = {
		a match {
			case pos if pos >= 0 => {
				countOnes32bFromZero(b) + (pos match {
					case 0 => 0
					case _ => -countOnes32bFromZero(a - 1)
				})
			}
			case _ => {
				countOnes32bToZero(a) + (b match {
					case strpos if strpos > 0 => countOnes32bFromZero(b)
					case strneg if strneg < -1 => -countOnes32bToZero(b + 1)
					case _ => 0
				})
			}
		}
	}

	def countOnes32bToZero(n: Int): Long = {
		(32 * -n.toLong) - countOnes32bFromZero(~n)
	}

	def countOnes32bFromZero(a: Int): Long = {
		if (a == 0) 0
		else if (a % 2 == 0) countOnes32bFromZero(a - 1) + countOnes32b(a)
		else (a.toLong + 1) / 2 + 2 * countOnes32bFromZero(a / 2)
	}

	def countOnes32b(x: Int): Long = {
		val i1 = x - ((x >> 1) & 0x55555555)
		val i2 = (i1 & 0x33333333) + ((i1 >> 2) & 0x33333333)
		return (((i2 + (i2 >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24
	}
}