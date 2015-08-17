package net.mauhiz.hu

import scala.annotation.tailrec
import scala.io.StdIn

object Seinfeld extends App {
	val lines = Iterator.continually { StdIn.readLine }.takeWhile { line: String => !line.startsWith("-") }

	lines.zipWithIndex.foreach {
		case (line, i) => println("Solution: " + (i + 1) + ". " + seinfeld(line.trim));
	}

	def seinfeld(line: String): Int = {
		println("Seinfelding: " + line)
		removeS(line) match {
			case "" => 0
			case x if x.startsWith("}") => 1 + seinfeld("{" + x.drop(1))
			case x if x.endsWith("{") => 1 + seinfeld(x.dropRight(1) + "}")
			case x => throw new Exception("Unsupported :" + x)
		}
	}

	@tailrec
	def removeS(line: String): String = {
		line.replaceAllLiterally("{}", "") match {
			case x if x == line => {
				println("removed S : " + x)
				x
			}
			case x => removeS(x)
		}

	}
}