package net.mauhiz.util

import org.scalatest.junit.AssertionsForJUnit
import scala.collection.mutable.ListBuffer
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.scalatest.junit.JUnitSuite

class TreeTest extends JUnitSuite {
  val nodes = ('A' to 'I').map { c: Char => (c, Node(c)) }.toMap
  val root = nodes('A')

  @Before def initialize = {
    root.left = Some(nodes('B'))
    root.right = Some(nodes('C'))
    nodes('B').left = Some(nodes('D'))
    nodes('B').right = Some(nodes('E'))
    nodes('C').left = Some(nodes('F'))
    nodes('C').right = Some(nodes('G'))
    nodes('E').right = Some(nodes('H'))
    nodes('F').left = Some(nodes('I'))
  }

  @Test def testSiblings = {
    nodes.values.foreach {
      n: Node[Char] =>
        println("Sibling of " + n + ": " + Tree.getSibling(Some(root), n))
    }
  }

  @Test def testLca = {
    println(Tree.findLCA(Some(root), Seq(nodes('I'), nodes('G'))))
  }
}