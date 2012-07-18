package net.mauhiz.euler

import net.mauhiz.util.Syntax._

object Problem1 extends App {
	time {
		println((1 until 1000).filter(x ⇒ x % 3 == 0 || x % 5 == 0).sum)
	}
}