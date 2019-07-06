package myWork

abstract class Meybe[+T] {
def map[B](f:T=>B):Meybe[B]
def filter[B](f:T=>Boolean):Meybe[T]
def flatMap[B](f:T=>Meybe[B]):Meybe[B]
}

case object MeybeNot extends Meybe[Nothing] {
  def map[B](f: Nothing => B): Meybe[B] = MeybeNot

  def filter[B](f: Nothing => Boolean): Meybe[Nothing] = MeybeNot

  def flatMap[B](f: Nothing => Meybe[B]): Meybe[B] = MeybeNot
}

case class Just[+T](value: T) extends Meybe[T] {
  def map[B](f: T => B): Meybe[B] = Just(f(value))

  def filter[B](f: T => Boolean): Meybe[T] = if(f(value)) this
  else MeybeNot

  def flatMap[B](f: T => Meybe[B]): Meybe[B] = f(value)
}
