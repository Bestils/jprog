package UG.cw8

object zadanie1 extends App{
///Zadanie 1. Korzystając z metod oferowanych przez kolekcje trawersowalne (Traversable[A]) zdefiniuj funkcję:
  //def sum(seq: Seq[Option[Double]]): Double = /* ... */
  //która zwróci sumę elementów sekwencji seq. Wszystkie elementy None powinny zostać pominięte.
  //Przykład:
  //Dla: seq = Seq(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6)), funkcja powinna zwrócić: 7.0.


  def sum(seq: Seq[Option[Double]]): Double=
  {
    seq.foldLeft(0.0)((a,b) => a+b.getOrElse(0.0))
  }
  val seq = Seq(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6))
println(sum(seq))
}
