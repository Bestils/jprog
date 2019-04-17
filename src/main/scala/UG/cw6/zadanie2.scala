package UG.cw6

object zadanie2 extends App {
  //Stwórz generyczną funkcję rekurencyjną:
  //def applyForAll2[A, B, C](seq1: Seq[A], seq2: Seq[B], f: (A, B) => C): Seq[C] = /* ... */
  //która dla wszystkich elementów seq1 i seq2 stosuje funckję f. Jeżeli, któraś z list jest dłuższa, elementy powinny zostać pominięte w dłuższej. Zdefiniuj funkcję z użyciem rekurencji ogonowej.
  //Przykład:
  //Dla: seq1 = Seq(1, 3, 5) i seq2 = Seq(2, 3, 4), funckja powinna zwrócić: seq = Seq(3, 6, 9).
  //Dla: seq1 = Seq(1, 3, 5, 6, 7) i seq2 = Seq(2, 3, 4), funckja powinna zwrócić: Seq(3, 6, 9).

  def applyForAll2[A, B, C](seq1: Seq[A], seq2: Seq[B], f: (A, B) => C): Seq[C] = {
    def helper[A, B, C](seq: (Seq[A], Seq[B]), acc: Seq[C], f: (A, B) => C): Seq[C] = seq match {

      case (Seq(), Seq()) => acc
      case (a +: r, Seq()) => acc
      case (Seq(), a +: r) => acc
      case (a1 +: r1, a2 +: r2) => helper((r1, r2), acc :+ f(a1, a2), f)


    }

    helper((seq1, seq2), Seq(), f)
  }

  var seq1 = Seq(1, 3, 5, 6, 7)
  var seq2 = Seq(2, 3, 4)


  print(applyForAll2(seq1, seq2, (A: Int, B: Int) => A + B))
}