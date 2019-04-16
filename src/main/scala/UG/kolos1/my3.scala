package UG.kolos1

object my2 extends App{

  def pot[A,B,C](seq:Seq[A])(op1: A=>B)(op2: A=>C): Seq[(B,C)]={

    def helper[A,B,C](seq:Seq[A],acc:Seq[(B,C)])(op1: A=>B)(op2: A=>C): Seq[(B,C)]=seq match{
      case Seq() => acc
      case a+: Seq() => acc:+(op1(a),op2(a))
      case a+: r => helper(r,acc:+(op1(a),op2(a)))(op1)(op2)


    }
    helper(seq,Seq())(op1)(op2)
  }
  var seq = Seq(1,2,3,4,5)
  println(pot(seq)(_*2)(_*3))
}
