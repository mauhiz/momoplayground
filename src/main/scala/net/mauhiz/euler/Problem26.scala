package net.mauhiz.euler
import net.mauhiz.util.Syntax._

object Problem26 extends App {

	def sol1(max: Int): Int = {
		val TEN = BigInt(10)
		def periodSize(i: Int): Option[Int] = {
			(1 to 2000).find {
				TEN.modPow(_, i) == 1
			}
		}

		val ps = (2 until max).map { periodSize }

		2 + ps.indexOf(Some(ps.flatten.max))
	}

	println(sol1(1000))
}