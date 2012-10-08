package net.mauhiz.euler

import scala.annotation.tailrec

object Problem31 extends App {

	def countPossibilities(availableCoins: List[Int], moneyInPence: Int): Int = {
		availableCoins match {
			case Nil ⇒ 0
			case head :: _ if head == moneyInPence ⇒ 1
			case head :: _ if head > moneyInPence ⇒ 0
			case head :: tail ⇒ countPossibilities(availableCoins, moneyInPence - head) + countPossibilities(tail, moneyInPence)
		}
	}

	val coins = List(1, 2, 5, 10, 20, 50, 100, 200)
	println(countPossibilities(coins, 200))
}