package net.mauhiz.codechef

import scala.io.StdIn

object HS08TEST extends App {
	val input = StdIn.readLine.split(' ')
	println(hs08(input(0).toInt, input(1).toDouble))

	def hs08(withdrawAmount: Int, balance: Double): String = {
		withdrawAmount match {
			case x if x % 5 != 0 => balance.toString
			case x if x > balance => balance.toString
			case x => (balance - x).formatted("%.2f")
		}
	}
}