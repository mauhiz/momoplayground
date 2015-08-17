package net.mauhiz.hu

import net.mauhiz.util.Syntax._
import scala.io.StdIn

// https://hallg.inf.unideb.hu/progcont/exercises.html?locale=en&pid=1631
object TanningSalonMain extends App {
	val lines = Iterator.continually(StdIn.readLine).takeWhile { line: String => line != "0" }
	val tanningSalon = new TanningSalon2

	lines.foreach {
		line =>
			val input = line.trim.split(" ")
			val numBeds = input(0).toInt
			val customersData = input(1)
			val walkedAway = tanningSalon.tan(numBeds, customersData)
			println(walkedAway match {
				case 0 => "All customers tanned successfully."
				case w => w + " customer(s) walked away."
			})
	}
}

trait TanningSalon {
	def tan(numBeds: Int, customersData: Seq[Char]): Int
}

class TanningSalon1 extends TanningSalon {
	def tan(numBeds: Int, customersData: Seq[Char]): Int = {

		def tanning(bedNumber: Int, part1: List[Char], part2: List[Char], inBed: List[Char], tanned: Int, walkedAway: Int): Int = {

			val actCustomer = part2.head
			val tanningTuple = (part1.indexOf(actCustomer), inBed.indexOf(actCustomer), bedNumber > inBed.length, part2.tail)

			tanningTuple match {
				case (_, _, _, Nil) => walkedAway
				// enter,can be tanned
				case (-1, -1, true, _) =>
					tanning(bedNumber, actCustomer :: part1, part2.tail, actCustomer :: inBed, tanned, walkedAway)
				// enter, can not be tanned
				case (-1, -1, false, _) =>
					tanning(bedNumber, actCustomer :: part1, part2.tail, inBed, tanned, walkedAway)
				//leave, not in bed
				case (x, -1, _, _) if x >= 0 =>
					tanning(bedNumber, actCustomer :: part1, part2.tail, inBed, tanned, walkedAway + 1)
				//leave, in bed
				case (x, y, _, _) if x >= 0 && y >= 0 =>
					tanning(bedNumber, actCustomer :: part1, part2.tail, inBed filterNot { _ == actCustomer }, tanned + 1, walkedAway)
			}
		}
		tanning(numBeds, List[Char](), customersData.toList, List[Char](), 0, 0)
	}
}

class TanningSalon2 extends TanningSalon {

	import scala.collection.mutable

	def tan(numBeds: Int, customersData: Seq[Char]): Int = {
		val currentCustomers = mutable.Set[Char]()
		val walkedAway = mutable.Set[Char]()
		customersData.filter {
			_ match {
				case c if currentCustomers.contains(c) => {
					// this customer is leaving after a tan
					currentCustomers.remove(c)
					false
				}
				case c if walkedAway.contains(c) => {
					// this customer has already walked away
					walkedAway.remove(c)
					false
				}
				case c if currentCustomers.size >= numBeds => {
					// this customer walks away
					walkedAway.add(c)
					true
				}
				case c => {
					// this customer lays for a tan
					currentCustomers.add(c)
					false
				}
			}
		}.size
	}
}

class TanningSalon3 extends TanningSalon {
	def tan(nbeds: Int, customers: Seq[Char]): Int = {
		def step(avail: Int, tanned: Set[Char], not_tanned: Set[Char], customers: List[Char]): Int = {
			customers match {
				case c :: cs if tanned(c) => step(avail + 1, tanned, not_tanned, cs)
				case c :: cs if not_tanned(c) => step(avail, tanned, not_tanned, cs)
				case c :: cs if avail > 0 => step(avail - 1, tanned + c, not_tanned, cs)
				case c :: cs if avail == 0 => step(avail, tanned, not_tanned + c, cs)
				case Nil => not_tanned.size
			}
		}
		step(nbeds, Set(), Set(), customers.toList)
	}

}