package UG.cw6

object zadanie3 extends App {
  // Stwórz generyczną funkcję rekurencyjną:
  //def divide[A](seq: Seq[A]): (Seq[A], Seq[A]) = /* ... */
  //która podzieli sekwencję seq na dwa elementy. W pierwszej będą się znajdywać elementy na parzystych indeksach w drugiej elementy na nie parzystych. Zdefiniuj funkcję z użyciem rekurencji ogonowej.
  //Przykład:
  //Dla: seq = Seq(1, 3, 5, 6, 7), funckja powinna zwrócić: (Seq(1, 5, 7), Seq(3, 6)).
  def divide[A](seq: Seq[A]): (Seq[A], Seq[A]) = {

    def aux(seq: Seq[A], out: (Seq[A], Seq[A]) = (Seq(), Seq())): (Seq[A], Seq[A]) = seq match {
      case e1 +: e2 +: s => aux(s, (e1 +: out._1, e2 +: out._2))
      case Seq(e) => ((e +: out._1).reverse, out._2.reverse)
      case Seq() => (out._1.reverse, out._2.reverse)
    }

    aux(seq)
  }
}
