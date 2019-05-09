package UG.kolos1.lmielewczyk

object zad3 extends App{
def countPair[A,B](seq:Seq[(A,B)])(leq:(A,B)=> Boolean):Int = {


  def helper[A](seq:Seq[(A,B)],odp:Int)(leq:(A,B)=>Boolean): Int =seq match  {
    case Seq() =>   odp
    case a+: r   if leq(a._1 ,a._2) => helper(r,odp+1)(leq)
    case a+: r   => helper(r,odp)(leq)




  }
 helper(seq,0)(leq)
  }
  var seq1 =Seq((2,4),(1,5),(5,10))
  var seq2 =Seq((2,4),(10,5),(5,10))
println(countPair(seq1)(_ < _ ))
println(countPair(seq2)(_ < _ ))

}
