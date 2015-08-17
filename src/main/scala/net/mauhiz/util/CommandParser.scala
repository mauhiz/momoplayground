package net.mauhiz.util

trait CommandParser extends App {
	type OptionMap = Map[String, Any]
	def isSwitch(s: String) = s(0) == '-'
	def readOptions(list: Seq[String]): Option[OptionMap]
}