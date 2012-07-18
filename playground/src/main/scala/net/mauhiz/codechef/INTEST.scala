package net.mauhiz.codechef

object INTEST extends App {

  val line = readLine.split(" ")
  val k = line.last.toInt
  val filtered = (1 to line.head.toInt).filter {
    i: Int ⇒ readLine.toInt % k == 0
  }
  println(filtered.size)
}