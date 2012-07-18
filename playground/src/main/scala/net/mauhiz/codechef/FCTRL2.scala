package net.mauhiz.codechef

import net.mauhiz.util.Math._

object FCTRL2 extends App {

	(1 to readLine.toInt).foreach {
		i: Int ⇒
			println(factorial(readLine.toInt))
	}
}