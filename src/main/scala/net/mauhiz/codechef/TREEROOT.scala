package net.mauhiz.codechef

import scala.io.StdIn
import scala.annotation.tailrec
import scala.util.Random

object Main {
  def main(args: Array[String]) = {
    val T = StdIn.readInt()
    assume(1 <= T && T <= 50)

    for (i <- 0 until T) {
      val N = StdIn.readInt()
      assume(1 <= N && N <= 30)

      val rootId = (0 until N).foldLeft(0) {
        case (acc, _) =>
          StdIn.readLine().split(' ').map(_.toInt) match {
            case Array(id, sigma) =>
              assume(1 <= id && id <= 1000)
              acc + id - sigma
          }
      }

      Console.println(rootId)
    }
  }
}