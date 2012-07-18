package net.mauhiz.euler

import net.mauhiz.util.Math.square

object Problem39 extends App {
  def countSolutions(p: Int): Int = {
    (1 to p - 2).map {
      a: Int ⇒
        (a to p - a - 1).filter {
          b: Int ⇒
            square(p - a - b) == square(a) + square(b)
        }
    }.size
  }
  def genTuple(i: Int): (Int, Int) = (i, countSolutions(i))
  val resultTuples = (1 to 1000).map(genTuple)
  val best = resultTuples.sortBy { _._2 }.last
  println(best._1)
}