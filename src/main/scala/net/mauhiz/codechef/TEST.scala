package net.mauhiz.codechef

import scala.io.StdIn

object TEST extends App {
	Iterator.continually { StdIn.readLine }.takeWhile { _ != "42" }.foreach { println }
}