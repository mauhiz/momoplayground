package net.mauhiz.util

import scala.math._
import scala.annotation.tailrec
import scala.math.BigDecimal.RoundingMode.HALF_EVEN
import java.util.LinkedList
import scala.collection.mutable.Builder

object Math {

	object Polygone {

		def polygone(s: Int)(n: Long): Long = ((s - 2) * square(n) - (s - 4) * n) / 2
		def triangle(n: Long) = polygone(3)(n)
		def pentagone(n: Long) = polygone(5)(n)
		def hexagone(n: Long) = polygone(6)(n)

		def reversePolygone(s: Int)(x: Long): Double = ((sqrt((8 * s - 16) * x + square(s - 4)) + s - 4) / (2 * s - 4))

		def isPolygone(s: Int)(x: Long): Boolean = isWhole(reversePolygone(s)(x))
		def isTriangle(x: Long) = isPolygone(3)(x)
		def isPentagone(x: Long) = isPolygone(5)(x)
		def isHexagone(x: Long) = isPolygone(6)(x)

		def polygoneStream(s: Int)(n: Long): Stream[Long] = polygone(s)(n) #:: polygoneStream(s)(n + 1)
		def triangleStream(n: Long) = polygoneStream(3)(n)
		def pentagoneStream(n: Long) = polygoneStream(5)(n)
		def hexagoneStream(n: Long) = polygoneStream(6)(n)

		lazy val triangles = triangleStream(0)
		lazy val pentagones = pentagoneStream(0)
		lazy val hexagones = hexagoneStream(0)
	}

	def isWhole(d: Double): Boolean = math.ceil(d) == d
	def decimalPart(d: BigDecimal): Double = (d - BigDecimal(d.toBigInt)).doubleValue

	def quadraticFormula(a: Long, b: Long, c: Long): (Double, Double) = {
		val delta = sqrt(square(b) - 4 * a * c)
		val denom = 2 * a
		((-b + delta) / denom, (-b - delta) / denom)
	}

	def square(n: Long) = n * n
	def square(n: Int) = n * n
	def square(n: BigInt) = n * n

	def isOdd(n: Long) = n % 2 == 1

	def gcd(a: Int, b: Int): Int = {
		def gcd1(n: Int, d: Int): Int = {
			d match {
				case 0 ⇒ n
				case _ ⇒ gcd(d, n % d)
			}
		}
		gcd1(a max b, a min b)
	}
	def lcm(a: Int, b: Int): Int = a * (b / gcd(a, b))

	val phi: Double = (1 + math.sqrt(5)) / 2

	object Digit {
		def digitToInt(c: Char): Int = c - '0'
		def countDigits(l: Long): Int = 1 + math.log10(l).toInt
		def lastDigits(n: Int)(b: BigInt): BigInt = b.mod(BigInt(10).pow(n))
	}

	object Pandigital {
		def isPandigital(order: Int)(target: Any) = isStrPandigital(order)(target.toString)

		def isPandigital(target: Any) = isStrPandigital(target.toString)

		def isStrPandigital(target: String): Boolean = isStrPandigital(target.length)(target)

		def isStrPandigital(order: Int)(target: String): Boolean = {
			('1' until ('1' + order).asInstanceOf[Char]).forall {
				target.contains(_)
			}
		}
	}

	def fibonacciModulo(mod: Long): Stream[Long] = fibonacci.map { _.mod(BigInt(mod)).toLong }

	lazy val fibonacci: Stream[BigInt] = Stream.cons(0, Stream.cons(1, fibonacci.zip(fibonacci.tail).map(p ⇒ p._1 + p._2)))

	def longStream(n: Long): Stream[Long] = n #:: longStream(n + 1)
	lazy val longs = longStream(1)

	def oddStream(n: Long): Stream[Long] = longStream(n).filter { _ % 2 == 1 }

	lazy val odds: Stream[Long] = oddStream(1)
	lazy val evens: Stream[Long] = longStream(0).filter { _ % 2 == 0 }

	def factorial(k: Int): BigInt = factorialStream.apply(k)

	lazy val factorialStream: Stream[BigInt] = {
		1 #:: Stream.from(1).map {
			l: Int ⇒ l * factorial(l - 1)
		}
	}
}