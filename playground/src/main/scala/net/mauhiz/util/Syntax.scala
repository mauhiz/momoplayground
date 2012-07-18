package net.mauhiz.util

import scala.actors.Futures.awaitAll
import scala.actors.Futures.future

object Syntax {
	def using[Closeable <: { def close(): Unit }, B](closeable: Closeable)(getB: Closeable ⇒ B): B = {
		try {
			getB(closeable)
		} finally {
			closeable.close()
		}
	}

	def time[R](block: ⇒ R): R = {
		val start = System.nanoTime
		try {
			block
		} finally {
			System.nanoTime - start match {
				case d if d < 1000 ⇒ println("Elapsed time: less than 1µs")
				case d if d < 1000000 ⇒ println("Elapsed time: %.2f µs".format(d / 1000f))
				case d if d < 1000000000 ⇒ println("Elapsed time: %.2f ms".format(d / 1000000f))
				case d ⇒ println("Elapsed time: %.2f s".format(d / 1000000000f))
			}
		}
	}

	def runWithTimeout[T](timeoutMs: Long)(f: ⇒ T): Option[T] = {
		awaitAll(timeoutMs, future(f)).head.asInstanceOf[Option[T]]
	}

	def runWithTimeout[T](timeoutMs: Long, default: T)(f: ⇒ T): T = {
		runWithTimeout(timeoutMs)(f).getOrElse(default)
	}

	def timeOrAbort[R](maxtimeMs: Long)(block: ⇒ R): Option[R] = {
		runWithTimeout(maxtimeMs) { time { block } }
	}
}