package net.mauhiz.codechef

object INTEST extends App {
	val line = readLine.split(" ")
	println(process2(line(0).toInt, line(1).toInt))

	def process(n: Int, k: Int): Int = {
		(for (i ← 1 to n if readLine.toInt % k == 0) yield i).size
	}

	def process2(n: Int, k: Int): Int = {
		(1 to n).foldLeft(0) {
			case (acc, next) ⇒ next match {
				case _ if readLine.toInt % k == 0 ⇒ acc + 1
				case _ ⇒ acc
			}
		}
	}

}