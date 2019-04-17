package UG.kolos1.lmielewczyk

object zad2 extends App{
  def sliceMap[A,B](seq:Seq[A],from:Int,until:Int)(op:(A) => B): Seq[B] = {

    def helper[A,B](seq:Seq[A],from:Int,until:Int,i:Int,acc:Seq[B])(op:(A) => B): Seq[B] = seq match {
      case Seq() =>   acc
      case a+: r if (i>=from && i<=until) =>  helper(r,from,until,i+1,acc:+op(a))(op)
      case a+: r  =>  helper(r,from,until,i+1,acc)(op)

    }
    helper(seq,from,until,0,Seq())(op)

  }

  var seq = Seq(1,2,3,4,5)
  println(sliceMap(seq,1,3)(_*2))

}
