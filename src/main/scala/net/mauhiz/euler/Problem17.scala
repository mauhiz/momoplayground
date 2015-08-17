package net.mauhiz.euler

import net.mauhiz.util.Syntax._

object Problem17 extends App {
	def toLetters(n: Int): String = {
		n match {
			case 0 => ""
			case 1 => "one"
			case 2 => "two"
			case 3 => "three"
			case 4 => "four"
			case 5 => "five"
			case 6 => "six"
			case 7 => "seven"
			case 8 => "eight"
			case 9 => "nine"
			case 10 => "ten"
			case 11 => "eleven"
			case 12 => "twelve"
			case 13 => "thirteen"
			case 14 => "fourteen"
			case 15 => "fifteen"
			case 16 => "sixteen"
			case 17 => "seventeen"
			case 18 => "eighteen"
			case 19 => "nineteen"
			case 20 => "twenty"
			case 30 => "thirty"
			case 40 => "forty"
			case 50 => "fifty"
			case 60 => "sixty"
			case 70 => "seventy"
			case 80 => "eighty"
			case 90 => "ninety"
			case _ => {
				if (n >= 1000) {
					val numThousand = n / 1000
					toLetters(numThousand) + "thousand" + toLetters(n - 1000 * numThousand)
				} else if (n >= 100) {
					val numHundred = n / 100
					val unit = n - 100 * numHundred
					if (unit == 0) {
						toLetters(numHundred) + "hundred"
					} else {
						toLetters(numHundred) + "hundred" + "and" + toLetters(n - 100 * numHundred)
					}
				} else {
					val unit = n % 10
					val remain = n - unit
					toLetters(remain) + toLetters(unit)
				}
			}
		}
	}

	def sol1(max: Int): Int = (1 to max).map { toLetters(_).length }.sum
	println(sol1(1000))
}