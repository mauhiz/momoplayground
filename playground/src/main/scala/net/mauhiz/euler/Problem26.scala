package net.mauhiz.euler
import net.mauhiz.util.Syntax._

object Problem26 extends App {
	def periodSize(i: Int): Option[Int] = (1 to 2000).find { p: Int ⇒ BigInt(10).modPow(p, i) == 1 }

	lazy val ps: Seq[Option[Int]] = (2 until 1000).map(periodSize)

	time {
		println(2 + ps.indexOf(Some(ps.flatten.max)))
	}
}