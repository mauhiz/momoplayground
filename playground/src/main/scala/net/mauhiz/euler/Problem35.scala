package net.mauhiz.euler

import scala.collection.mutable

import net.mauhiz.util.Math._
import net.mauhiz.util.Rotation

object Problem35 extends App {

  def rotateInt(n: Int): Seq[Int] = {
    val acc = new mutable.HashSet[Int]
    (1 to n).foreach { Rotation.rotate(n.toString, _).foreach { acc += _.toInt } }
    acc.toSeq
  }

  def checkCyclicPrime(i: Int): Boolean = {
    !rotateInt(i).exists {
      !EratosthenesSiede.isPrime(_)
    }
  }

  // val max = 1000000
  val max = 100
  val cyclicPrimes = (1 to max).filter(checkCyclicPrime);
  cyclicPrimes.foreach(println)
  println("result: " + cyclicPrimes.size)
}