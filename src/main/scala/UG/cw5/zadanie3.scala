package UG.cw5

object zadanie3 {
// Stwórz generyczną funkcję rekurencyjną:
  //def deStutter[A](seq: Seq[A]): Seq[A] = = /* ... */
  //która usunie z sekwencji seq wszystkie powtarzające się ciągi. Zdefiniuj funkcję z użyciem rekurencji ogonowej.
  //Przykład:
  //Dla: seq = Seq(1, 1, 2, 4, 4, 4, 1, 3), funckja powinna zwrócić: Seq(1, 2, 4, 1, 3).

  def deStutter[A](seq: Seq[A]): Seq[A] =  {
  def deStutterHelper[A](seq: Seq[A],head : Seq[A]): Seq[A] = seq match {
    case a +: b+: r if (a==b) => deStutterHelper(r,head:+a)
    case a +: b+: r  => deStutterHelper(r,head:+a:+b)
    case Seq(a,b) if (a==b) => head:+a
    case Seq(a,b)  => head:+a:+b
    case Seq(a) if (head.head ==a )=> head
    case Seq(a) => head:+a

  }
}}
