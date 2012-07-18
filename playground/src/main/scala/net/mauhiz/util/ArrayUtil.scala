package net.mauhiz.util

object ArrayUtil {
	def binarySearch[A <: Comparable[A]](needle: A, haystack: Array[A]): Option[Int] = {
			def recurse(low: Int, high: Int): Option[Int] = {
				if (high < low) {
					None
				} else {
					val mid = (low + high) / 2
					haystack(mid).compareTo(needle) match {
						case comp if comp > 0 ⇒ recurse(low, mid - 1)
						case comp if comp < 0 ⇒ recurse(mid + 1, high)
						case _ ⇒ Some(mid)
					}
				}
			}
		recurse(0, haystack.size - 1)
	}
}