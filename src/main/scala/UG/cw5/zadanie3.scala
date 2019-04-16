package UG.cw5

object zadanie3 extends App{
// Stwórz generyczną funkcję rekurencyjną:
  //def deStutter[A](seq: Seq[A]): Seq[A] = = /* ... */
  //która usunie z sekwencji seq wszystkie powtarzające się ciągi. Zdefiniuj funkcję z użyciem rekurencji ogonowej.
  //Przykład:
  //Dla: seq = Seq(1, 1, 2, 4, 4, 4, 1, 3), funckja powinna zwrócić: Seq(1, 2, 4, 1, 3).

  def deStutter[A](seq: Seq[A]): Seq[A] =  {
  def deStutterHelper[A](seq: Seq[A],head : Seq[A]): Seq[A] = seq match {

    case Seq(a,b) if (a==b) => head
    case Seq(a,b)  => head:+a:+b


    case a +: b+: r if (a==b) => deStutterHelper(b+:r,head)
    case a +: b+: r  => deStutterHelper(b+:r,head:+a)

  }
    deStutterHelper(seq,Seq())
}


print(deStutter(Seq(1, 1, 2, 4, 4, 4, 1, 3)))

}
