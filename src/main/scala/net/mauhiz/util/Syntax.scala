package net.mauhiz.util

import scala.language.reflectiveCalls
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.Try

object Syntax {
	def using[Closeable <: { def close(): Unit }, B](closeable: Closeable)(getB: Closeable => B): B = {
		try {
			getB(closeable)
		} finally {
			closeable.close
		}
	}

	def printTime[R](block: => R): R = {
		val start = System.nanoTime
		val R = block
		println("Elapsed time: " + prettyPrintTime(System.nanoTime - start))
		R
	}

	def time(block: => Unit): Long = {
		val start = System.nanoTime
		block
		System.nanoTime - start
	}

	def bench(numRuns: Int)(block: => Unit): Double = {
		(1 to numRuns).map {
			_ => time { block }
		}.sum.toDouble / numRuns
	}

	def printBench(numRuns: Int)(block: => Unit): Unit = {
		val avgTime = bench(numRuns) { block }
		println("Average run time: " + prettyPrintTime(avgTime.toLong))
	}

	def prettyPrintTime(time: Long): String = {
		time match {
			case d if d < 1000 => "less than 1µs"
			case d if d < 1000000 => "%.2f µs".format(d / 1000f)
			case d if d < 1000000000 => "%.2f ms".format(d / 1000000f)
			case d => "%.2f s".format(d / 1000000000f)
		}
	}

	def runWithTimeout[T](timeoutMs: Duration)(f: => T): Option[T] = {
    import scala.concurrent.ExecutionContext.Implicits.global
		Try(Await.result(Future(f), timeoutMs)).toOption
	}

	def runWithTimeout[T](timeoutMs: Duration, default: T)(f: => T): T = {
		runWithTimeout(timeoutMs)(f).getOrElse(default)
	}

	def timeOrAbort[R](maxtimeMs: Duration)(block: => R): Option[R] = {
		runWithTimeout(maxtimeMs) { printTime { block } }
	}
}