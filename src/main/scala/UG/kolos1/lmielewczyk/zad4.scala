package UG.kolos1.lmielewczyk

object zad4 extends App{
  def  farthestPair(seq: Seq[(Double,Double)]):(Double,Double) ={

    def helper(seq: Seq[(Double,Double)],maxInt:Double,max:(Double,Double)):(Double,Double) = seq match {

      case Seq() => max
      case a+: r   if math.abs(a._1 - a._2)>maxInt =>helper(r,math.abs(a._1 - a._2),(a._1,a._2))
      case a+: r  =>helper(r,maxInt,max)


    }
    helper(seq,0,(0.0,0.0))
  }
var seq1 = Seq((1.0,2.0),(2.0,2.5),(2.5,3.5),(3.0,5.0),(-1.0,0.0))
var seq = Seq()
  println(farthestPair(seq1))
  println(farthestPair(seq))
}
