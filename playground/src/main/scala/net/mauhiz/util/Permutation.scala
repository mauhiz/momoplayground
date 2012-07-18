package net.mauhiz.util

import scala.collection.mutable

object Permutation {

	def is[A](a: Seq[A], b: Seq[A]): Boolean = a.size == b.size && internalIs(a, b)

	def internalIs[A](a: Seq[A], b: Seq[A]): Boolean = mapOccurences(a) equals mapOccurences(b)

	def mapOccurences[A](a: Seq[A]): mutable.Map[A, Int] = {
		val occurences = mutable.Map[A, Int]()
		a.foreach {
			item: A ⇒
				val oldCount = occurences.getOrElse(item, 0)
				occurences.put(item, oldCount + 1)
		}
		occurences
	}
}