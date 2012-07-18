package net.mauhiz.euler

import scala.io.Source

import net.mauhiz.util.Graph.Triangle._
import net.mauhiz.util.Syntax._

object Problem67 extends App {
	runWithTimeout(60 * 1000) {
		val source = Source.fromURL("http://projecteuler.net/project/triangle.txt").getLines.toList
		val grid = source.map {
			s: String ⇒
				s.split("\\s+")
					.toList
					.map { tok: String ⇒ tok.stripLineEnd.toInt }
		}

		println(reduce(grid.reverse).head.head)
	}
}