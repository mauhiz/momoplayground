package net.mauhiz.euler

import net.mauhiz.util.Syntax._
import scala.concurrent.duration._

object Problem97 extends App {

	runWithTimeout(60.minutes) {
		lazy val nonM = (BigInt(28433) * BigInt(2).pow(7830457)) + BigInt(1)
		println(nonM.mod(BigInt(10).pow(10)))
	}
}