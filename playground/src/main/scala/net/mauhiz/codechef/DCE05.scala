package net.mauhiz.codechef

object DCE05 extends App {
	def subPow2(n: Int): Int = {
		n match {
			case 0 ⇒ 0
			case 1 ⇒ 1
			case _ ⇒ 2 * subPow2(n / 2)
		}
	}

	val T = readLine.toInt
	for (_ ← 1 to T) {
		println(subPow2(readLine.toInt))
	}
}