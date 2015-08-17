package net.mauhiz.euler

import net.mauhiz.util.Math._
import net.mauhiz.util.Syntax._

object Problem44 extends App {

	lazy val d_sols = for (
		penta <- Polygone.pentagones.drop(1); penta2 <- Polygone.pentagones.drop(1).takeWhile { _ < penta };
		if (Polygone.isPentagone(penta + penta2) && Polygone.isPentagone(penta - penta2))
	) yield (penta, penta2)

	assert(Polygone.pentagones(4) + Polygone.pentagones(7) == Polygone.pentagones(8))
	lazy val d_resp = d_sols.head

	time {
		println(d_resp._1 - d_resp._2) //5482660
	}
}