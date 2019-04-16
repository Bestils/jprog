package UG.kolos1

object Main extends App {

def inverseCompress[A](seq:Seq[(A,Int)]): Seq[A] = {
    def helper[A](seq:Seq[(A,Int)], acc: Seq[A]): Seq[A] = {
        (seq) match {
            case(Seq()) => acc
            case(a1 +: seq) if(a1._2 == 0) => helper(seq, acc)
            case(a1 +: seq) => helper((a1._1,(a1._2)-1) +: seq, acc :+ a1._1)
        }
    }
helper(seq, Seq())
}
var seq = Seq(('a',2),('b', 3),('c',1),('d', 0))
println(inverseCompress(seq))
}