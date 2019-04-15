package UG.cw4

object zadanie5 extends App{


  def forall[A](a: Seq[A])(pred: A => Boolean): Boolean = a match {
    case Seq() => true
    case e +: _ if !pred(e) => false
    case _ +: s => forall(s)(pred)
  }

  println(forall(Seq(1,3,5,8))(n=> n%2 !=0 ))
}
