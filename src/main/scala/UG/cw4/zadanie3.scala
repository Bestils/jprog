package UG.cw4

object zadanie3 {
  type MSet[A] = A => Int

  var a:MSet[Int] = (n: Int) => n match {
    case 1 => 2
    case 3 => 1
    case _ => 0
  }

  def +[A](s1: MSet[A], s2: MSet[A]): MSet[A] = (a:A)=>s1(a)+s2(a)
  def -[A](s1: MSet[A], s2: MSet[A]): MSet[A] = (a:A)=>    if(s1(a)-s2(a)> 0) s1(a)-s2(a) else s2(a)-s1(a)


  def &[A](s1: MSet[A], s2: MSet[A]): MSet[A] = /* ... */
}
