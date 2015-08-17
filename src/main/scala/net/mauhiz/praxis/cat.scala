package net.mauhiz.praxis

import java.io.{InputStream, FileInputStream, File, BufferedInputStream}

import net.mauhiz.util.Syntax.using

object cat extends App {
	val options: Tuple2[Boolean, Option[String]] = args.toSeq match {
		case Seq() => (false, None)
		case Seq("-u", filename) => (false, Some(filename.asInstanceOf[String]))
		case Seq(filename) => (true, Some(filename))
	}

	if (options._2.isDefined) {
		val file = new File(options._2.get)
		if (options._1) {
			readFromFileBuffered(file)
		} else {
			readFromFile(file)
		}
	} else {
		readFromConsole
	}

	def readLoopBuffered(is: InputStream): Unit = {
		val buf = new Array[Byte](512)
		is.read(buf) match {
			case -1 => Unit
			case _ => {
				System.out.write(buf)
				readLoopBuffered(is)
			}
		}
	}

	def readLoopUnbuffered(is: InputStream): Unit = {
		is.read match {
			case -1 => Unit
			case r => {
				System.out.write(r)
				readLoopUnbuffered(is)
			}
		}
	}

	def readFromFileBuffered(file: File): Unit = {
		using(new BufferedInputStream(new FileInputStream(file))) {
			readLoopBuffered _
		}
	}

	def readFromFile(file: File): Unit = {
		using(new FileInputStream(file)) {
			readLoopUnbuffered _
		}
	}

	def readFromConsole: Unit = readLoopUnbuffered(System.in)
}