package net.mauhiz.util

object Tree {
  def findLCA[A](root: Option[Node[A]], args: Seq[Node[A]]): Option[Node[A]] = {
    root match {
      case None => None
      case Some(theRoot) if (args.contains(theRoot)) => Some(theRoot)
      case Some(theRoot) => {
        findLCA(theRoot.left, args) match {
          case None => findLCA(theRoot.right, args)
          case found1 => {
            findLCA(theRoot.right, args) match {
              case None => found1
              case Some(found2) => Some(theRoot)
            }
          }
        }
      }
    }
  }

  def getSibling[A](root: Option[Node[A]], me: Node[A]): Option[Node[A]] = {
    root match {
      case None => None
      case Some(theRoot) => {
        theRoot match {
          case _ if (theRoot == me) => None
          case _ if (theRoot.left == Some(me)) => theRoot.right
          case _ if (theRoot.right == Some(me)) => theRoot.left
          case _ =>
            getSibling(theRoot.left, me) match {
              case None => getSibling(theRoot.right, me)
              case Some(found) => Some(found)
            }
        }
      }
    }
  }
}

case class Node[A](val name: A) {
  var left: Option[Node[A]] = None
  var right: Option[Node[A]] = None
}