package UG.kolos1

object my4 extends App{

  def inverseCompress[A](seq:Seq[(A,Int)]): Seq[A] = {

    def helper[A](seq:Seq[(A,Int)],acc:Seq[A]): Seq[A] =seq match  {
      case Seq() =>   acc
      case a+: r   if a._2 == 0 => helper(r,acc)
      case a+: r   => helper((a._1,a._2-1)+: r,acc:+a._1)




    }
    helper(seq, Seq())
  }
  var seq = Seq(('a',2),('b', 3),('c',1),('d', 0))
  println(inverseCompress(seq))
}