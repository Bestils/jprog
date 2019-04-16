package UG.cw5

object zadanie1 extends App{
// Stwórz generyczną funkcję rekurencyjną:
  //def isOrdered[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean = /* ... */
  //która sprawdzi czy elementy sekwencji seq są ułożone zgodnie z porządkiem leq.
  // Zdefiniuj funkcję z użyciem rekurencji ogonowej.

  def isOrdered[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean = seq match {
    case Seq() => true
    case Seq(_)  => true
    case a +: b +: r if leq(a,b) =>isOrdered[A](b+:r)(leq)
    case _ => false
  }
}
