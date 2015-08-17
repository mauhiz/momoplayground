package net.mauhiz.util

import net.mauhiz.util.Syntax._
import java.sql.{ ResultSet, DriverManager, Connection }
import java.sql.PreparedStatement
import scala.collection.mutable

object Sql {

	def getPlaceHolders(size: Int): String = {
		size match {
			case 1 => "?"
			case _ => "?, " + getPlaceHolders(size - 1)
		}
	}

	def processResultSet(rs: ResultSet)(processor: ResultSet => Unit): Unit = {
		while (rs.next) {
			processor(rs)
		}
	}

	def readResultSet[B](rs: ResultSet)(rsProcessor: ResultSet => B): Seq[B] = {
		val buf = new mutable.ListBuffer[B]
		processResultSet(rs) { buf += rsProcessor(_) }
		buf
	}

	def queryForList[B](conn: Connection)(sqlBuilder: => String)(psSetter: PreparedStatement => Unit)(rsProcessor: ResultSet => B): Seq[B] = {
		using(conn) {
			conn1: Connection =>
				using(conn1.prepareStatement(sqlBuilder)) {
					ps: PreparedStatement =>
						psSetter(ps)
						using(ps.executeQuery) { readResultSet(_)(rsProcessor) }
				}

		}
	}

	def getConnection: Connection = DriverManager.getConnection("jdbc:mysql://host:3306/schema", "user", "password")

}