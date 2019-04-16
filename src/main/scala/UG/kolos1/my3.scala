package UG.kolos1

import UG.kolos1.zad3.checkElement

object my3 extends App{

  def checkElement[A](seq:Seq[A],ind:Int)(leq:(A) => Boolean): Boolean = {

    def helper[A](seq:Seq[A],ind:Int,i:Int)(leq:(A) => Boolean): Boolean = seq match {
      case Seq() =>   false
      case a+: r if i==ind  =>  leq(a)
      case a+: r  => helper(r,ind,i=i+1)(leq)



    }
    helper(seq,ind,0)(leq)

  }
  var seq = Seq(1,2,3)
  println(checkElement(seq, 45)(_<3))
  println(checkElement(seq, 1)(_<2))
}
