package net.mauhiz.codechef

object HS08TEST extends App {
  val input = readLine.split(" ")
  val withdrawAmount = input.head.toInt
  if (withdrawAmount % 5 != 0) {
    println(input.tail)
  } else {
    val balance = input.last.toDouble
    if (withdrawAmount > balance) {
      println(input.tail)
    } else {
      println((balance - withdrawAmount).formatted("%.2f"))
    }
  }
}