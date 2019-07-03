package myWork

abstract class MyTrueList[+A] {

  def head: A

  def tail: MyTrueList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyTrueList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyTrueList[B]

  def filter(predicate: MyPredicate[A]): MyTrueList[A]

  def flatMap[B](transformer: MyTransformer[A, MyTrueList[B]]): MyTrueList[B]
// concatenation
  def ++[B >: A](list: MyTrueList[B]): MyTrueList[B]
}

trait MyPredicate[-T] {
  def test(t: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(a: A): B
}


case object Empty extends MyTrueList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyTrueList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyTrueList[B] = new Const(element, Empty)

  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyTrueList[B] = Empty

  def filter(predicate: MyPredicate[Nothing]): MyTrueList[Nothing] = Empty

  def flatMap[B](transformer: MyTransformer[Nothing, MyTrueList[B]]): MyTrueList[B] = Empty

  def++[B >: Nothing](list: MyTrueList[B]):MyTrueList[B]=list


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

  def map[B](transformer: MyTransformer[A, B]): MyTrueList[B] = {
    new Const(transformer.transform(h), t.map(transformer))

  }

  def filter(predicate: MyPredicate[A]): MyTrueList[A] = {
    if (predicate.test(h)) new Const(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def flatMap[B](transformer: MyTransformer[A, MyTrueList[B]]): MyTrueList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)
}

case object ListTest extends App {
  val listOfIntegers: MyTrueList[Int] = new Const(1, new Const(2, new Const(3, Empty)))
  val anotherListOfIntegers : MyTrueList[Int] = new Const(4, new Const(5, new Const(6, Empty)))
  val listOfStrings: MyTrueList[String] = new Const("Hello", new Const("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(new MyTransformer[Int,Int] {
    override def transform(a: Int): Int = a*2
  }))
  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(t: Int): Boolean = t % 2 == 0
  }).toString)

  println(listOfIntegers ++ anotherListOfIntegers)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyTrueList[Int]] {
    override def transform(a: Int): MyTrueList[Int] = new Const(a, new Const(a+1,Empty))

  }).toString)
}