package net.mauhiz.playground

import scala.actors._

sealed trait Message
case object Exit extends Message
case class Unimportant(n: Int) extends Message
case class Important(n: Int) extends Message

class SafeExitingActor extends Actor {
	override def act: Nothing = react {
		case Exit => {
			println("exit requested, clearing the queue")
			exitRequested
		}
		case message => {
			processMessage(message, false)
			act
		}
	}

	// reactWithin(0) gives a TIMEOUT as soon as the mailbox is empty
	def exitRequested: Nothing = reactWithin(0) {
		case Exit => {
			println("extra exit requested, ignoring")
			exitRequested // already know about the exit, keep processing
		}
		case TIMEOUT => {
			println("timeout, queue is empty, shutting down")
			exit // TIMEOUT so nothing more to process, we can shut down
		}
		case message => {
			processMessage(message, true)
			exitRequested
		}
	}

	// process is a separate method to avoid duplicating in act and exitRequested
	def processMessage(message: Any, importantOnly: Boolean) = {
		message match {
			case Unimportant(n) if !importantOnly => println("Unimportant " + n)
			case Unimportant(n) => () // do nothing
			case Important(n) => println("Important! " + n)
		}
		Thread.sleep(100) // sleep a little to ensure mailbox backlog
	}
}

object SafeExitingActorTest extends App {
	val actor = new SafeExitingActor
	actor.start
	for (i <- 1 to 10) {
		actor ! Unimportant(i)
		actor ! Important(i)
	}
	actor ! Exit
	for (i <- 11 to 20) {
		actor ! Unimportant(i)
		actor ! Important(i)
	}
	actor ! Exit
	actor ! Important(100)

}
