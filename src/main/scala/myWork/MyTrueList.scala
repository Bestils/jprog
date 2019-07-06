package myWork

import scala.collection.script.Start

abstract class MyTrueList[+A] {

  def head: A

  def tail: MyTrueList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyTrueList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"
  //HOFS
  def map[B](transformer: A => B): MyTrueList[B]

  def filter(predicate: A => Boolean ): MyTrueList[A]

  def flatMap[B](transformer: A => MyTrueList[B]): MyTrueList[B]
// concatenation
  def ++[B >: A](list: MyTrueList[B]): MyTrueList[B]

  def foreach(f:A=>Unit) :Unit
  def sort (c:(A,A)=>Int) : MyTrueList[A]
  def zipWith[B,C](list:MyTrueList[B])(a:(A,B)=>C):MyTrueList[C]

  def fold[B](starts:B)(operator:(A,B)=>B):B

  def toCurry(f:(Int,Int)=>Int):(Int=>Int=>Int)
  def fromCurry(f:(Int=>Int=>Int)):((Int,Int)=>Int)
  def compose(f: Int => Int, g: Int=>Int) : Int =>Int
  def andThen(f: Int => Int, g: Int=>Int) : Int =>Int


}



case object Empty extends MyTrueList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyTrueList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyTrueList[B] = new Const(element, Empty)

  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyTrueList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyTrueList[Nothing] = Empty

  def flatMap[B](transformer: Nothing  => MyTrueList[B]): MyTrueList[B] = Empty

  def++[B >: Nothing](list: MyTrueList[B]):MyTrueList[B]=list

  def foreach(f: Nothing => Unit): Unit = ()



   def sort(c: (Nothing, Nothing) => Int): MyTrueList[Nothing] = Empty

   def zipWith[B, C](list: MyTrueList[B])(a: (Nothing, B) => C): MyTrueList[Nothing] = {
     if  (!list.isEmpty) throw new RuntimeException("List do not have the same length")
     else Empty
   }

  def fold[B](starts: B)(operator: (Nothing, B) => B): B = starts

   def toCurry(f: (Int, Int) => Int): Int => Int => Int = x => y => f(x,y)

   def fromCurry(f: Int => Int => Int): (Int, Int) => Int = (x,y) => f(x)(y)

  def compose(f: Int => Int, g: Int => Int): Int => Int = x=> f(g(x))

  def andThen(f: Int => Int, g: Int => Int): Int => Int = x=> g(f(x))
}

case class Const[+A](h: A, t: MyTrueList[A]) extends MyTrueList[A] {
  def head: A = h

  def tail: MyTrueList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyTrueList[B] = new Const(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  def++[B >: A](list: MyTrueList[B]):MyTrueList[B]=new Const(h, t ++ list)



  def map[B](transformer: A=>B): MyTrueList[B] = {
    new Const(transformer(h), t.map(transformer))

  }

  def filter(predicate: A => Boolean): MyTrueList[A] = {
    if (predicate(h)) new Const(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def flatMap[B](transformer: A => MyTrueList[B]): MyTrueList[B] =
    transformer(h) ++ t.flatMap(transformer)

  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)

  }

  def sort(c: (A, A) => Int): MyTrueList[A] = {
    def insert(x : A, sortedList: MyTrueList[A]): MyTrueList[A] =
      if(sortedList.isEmpty) new Const(x,Empty)
      else if(c(x,sortedList.head) <0)new Const(x,sortedList)
      else new Const (sortedList.head, insert(x, sortedList.tail))
      val sortedTail = t.sort(c)
      insert(h,sortedTail)

  }

  def zipWith[B, C](list: MyTrueList[B])(zip: (A, B) => C): MyTrueList[C] = {
    if  (list.isEmpty) throw new RuntimeException("List do not have the same length")
    else new Const(zip(h,list.head),t.zipWith(list.tail)(zip))
  }


  def fold[B](starts: B)(operator: (A, B) => B): B  = {
    val newStart = operator(h,starts)
    t.fold(newStart)(operator)
  }
  def toCurry(f: (Int, Int) => Int): Int => Int => Int = x => y => f(x,y)

  def fromCurry(f: Int => Int => Int): (Int, Int) => Int =  (x,y) => f(x)(y)

  def compose(f: Int => Int, g: Int => Int): Int => Int = x=> f(g(x))

  def andThen(f: Int => Int, g: Int => Int): Int => Int = x=> g(f(x))
}

case object ListTest extends App {
  val listOfIntegers: MyTrueList[Int] = new Const(1, new Const(2, new Const(3, Empty)))
  val anotherListOfIntegers : MyTrueList[Int] = new Const(4, new Const(5, new Const(6, Empty)))
  val listOfStrings: MyTrueList[String] = new Const("Hello", new Const("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(_*2))

  println(listOfIntegers.filter( _% 2 == 0
  ).toString)

  println(listOfIntegers ++ anotherListOfIntegers)
  println(listOfIntegers.flatMap((a: Int) => new Const(a, new Const(a + 1, Empty))).toString)

  def concat(a:String,b:String) : String = {a+b}

}