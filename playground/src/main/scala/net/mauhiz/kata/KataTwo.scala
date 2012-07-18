package net.mauhiz.kata

import java.util.Arrays
import java.lang.{ Comparable }
import java.util.Comparator

object KataTwo {
	def naturalComparator[T <: Comparable[T]]: Comparator[T] = {
		new Comparator[T] {
			override def compare(t1: T, t2: T): Int = {
				t1.compareTo(t2)
			}
		}
	}

	def binarySearch1[A <: Comparable[A]](needle: A, haystack: Array[A]): Option[Int] = {
		Arrays.binarySearch[A](haystack, 0, haystack.length, needle, naturalComparator[A]) match {
			case res if res < 0 ⇒ None
			case res ⇒ Some(res)
		}
	}

	def binarySearch2[A <: Comparable[A]](needle: A, haystack: Array[A]): Option[Int] = {
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