package myWork

import myWork.Main.Example3.{Decrement, Increment}

object Main {

  object Example1 {
    def sum(xs: List[Int]): Int = xs.foldLeft(0) { (acc, x) => acc + x }
  }

  object Task1 {
    def max(xs: List[Int]): Int = xs match {
      case Nil => Int.MinValue
      case _ => xs.foldLeft(0) { (y, x) => Math.max(y, x) }
    }

    def check = {
      assert(max(List(1, 2, 3)) == 3)
      assert(max(List(1, 5, 3)) == 5)
      assert(max(List.empty) == Int.MinValue)

      println("Task1 OK")
    }
  }

  object Example2 {
    def sum(xs: List[Int]): Int = xs match {
      case Nil => 0
      case x :: tail => x + sum(tail)
    }
  }

  object Task2 {
    def max(xs: List[Int]): Int = {
      def maxHelper(maxAtNow: Int, xs: List[Int]): Int = xs match {
        case Nil => Int.MinValue
        case x :: Nil => if (x > maxAtNow) x else maxAtNow
        case x :: y => maxHelper(if (x > maxAtNow) x else maxAtNow, y)

      }

      maxHelper(Int.MinValue, xs)
    }



    def check = {
      assert(max(List(1, 2, 3)) == 3)
      assert(max(List(1, 5, 3)) == 5)
      assert(max(List.empty) == Int.MinValue)

      println("Task2 OK")
    }
  }

    object Example3 {

    sealed trait UnaryOperator

    final case object Increment extends UnaryOperator

    final case object Decrement extends UnaryOperator

    def calculate(left: Int, op: UnaryOperator): Int = op match {
      case Increment => left + 1
      case Decrement => left - 1
    }
  }

  object Task3 {

    sealed trait BinaryOperator

    final case object Add extends BinaryOperator

    final case object Subtract extends BinaryOperator

    def calculate(left: Int, op: BinaryOperator, right: Int): Int = op match {
      case Add => left + right
      case Subtract => left - right
    }

    def check = {
      assert(calculate(1, Add, 2) == 3)
      assert(calculate(5, Subtract, 3) == 2)

      println("Task3 OK")
    }
  }

  object Example4 {

    // "Pimp my Library" pattern
    implicit class HalvableInt(val i: Int) extends AnyVal {
      def half(): Int = i / 2
    }

    def check = {


    }
  }

  object Task4 {

    implicit class WordsSpliter(val s: String) extends AnyVal {
      def words(): Seq[String] = s.split(" ")
    }

    def check = {
      assert("foo bar baz".words == Seq("foo", "bar", "baz"))
      assert("blah blah".words == Seq("blah", "blah"))

      println("Task4 OK")
    }
  }

  def main(args: Array[String]): Unit = {
    Task1.check
    Task2.check
    Task3.check
    Task4.check
  }
}