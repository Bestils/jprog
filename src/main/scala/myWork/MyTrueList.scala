package myWork

abstract class MyTrueList {

  def head: Int

  def tail: MyTrueList

  def isEmpty: Boolean

  def add(element: Int): MyTrueList

   def printElements: String

  override def toString: String = "[" + printElements + "]"

}

object Empty extends MyTrueList {
  def head: Int = throw new NoSuchElementException

  def tail: MyTrueList = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add(element: Int): MyTrueList = new Const(element, Empty)

   def printElements: String = ""
}
class Const(h:Int, t:MyTrueList) extends MyTrueList {
  override def head: Int = h

  override def tail: MyTrueList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): MyTrueList = new Const(element,this)

  override  def printElements: String =
    if (t.isEmpty)  "" + h
  else h + " " + t.printElements
}
object  ListTest extends App {
  val list = new Const(1,new Const(2, new Const(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.toString)
}