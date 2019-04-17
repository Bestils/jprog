package UG.cw6

object zadanie2 extends App{
//Stwórz generyczną funkcję rekurencyjną:
  //def insertInto[A](a: A, seq: Seq[A])(leq: (A, A) => Boolean): Seq[A] = /* ... */
  //która wstawi element a do sekwencji seq zgodnie z porządkiem określonym przez leq. Zdefiniuj funkcję z użyciem rekurencji ogonowej.
  //Przykład:
  //Dla: seq = Seq(1, 2, 4, 6), a = 3 i leq = (_ < _), funckja powinna zwrócić: Seq(1, 2, 3, 4, 6).

  def insertInto[A](a: A, seq: Seq[A])(leq: (A, A) => Boolean) = {
    def insertIntoHelper[A](a: A,seq : Seq[A])(leq : (A,A) => Boolean) (head : Seq[A]):Seq[A] = seq match {

      case e+: s if leq(a,e) => (head :+ a :+ e) ++ s // ++ dodaje cały ciąg
      case e+: s  => insertIntoHelper[A](a,s)(leq)(head:+e)
      case Seq(e) if leq(a,e) => head  :+ a :+ e
      case Seq(e) => head :+e :+ a
  }
insertIntoHelper(a,seq)(leq)(Seq())
  }
}
