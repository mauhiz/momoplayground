package net.mauhiz.util

object Truncation {

  def generateDistinctTruncations[A](coll: Seq[A]): Seq[Seq[A]] = {
    val truncRange = (1 until coll.size)
    val truncLeft = truncRange.map(coll.drop(_))
    val truncRight = truncRange.map(coll.dropRight(_))
    (truncLeft ++ truncRight).distinct
  }
}