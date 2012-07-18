package net.mauhiz.euler

object Problem31 extends App {
  val coins = List(1, 2, 5, 10, 20, 50, 100, 200)
  def countPossibilities(availableCoins: List[Int], moneyInPence: Int): Int = availableCoins match {
    case head :: tail ⇒
      if (head > moneyInPence) {
        0
      } else if (moneyInPence == head) {
        1
      } else {
        countPossibilities(availableCoins, moneyInPence - head) + countPossibilities(tail, moneyInPence)
      }
    case _ ⇒ 0
  }

  println(countPossibilities(coins, 200))
}