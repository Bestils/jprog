package UG.kolos1

object zad3 extends App {

def checkElement[A](seq:Seq[A],ind:Int)(leq:(A) => Boolean): Boolean = {
    def helper[A](seq:Seq[A],ind:Int, i: Int)(leq:(A) => Boolean): Boolean = {
        (seq) match {
            //case(a1 +: Seq()) if(i==ind) => leq(a1)
            case(a1 +: seq) if(i==ind) => leq(a1)
            case(a1 +: seq) => helper(seq, ind, i+1)(leq)
        }
    }
helper(seq,ind,0)(leq)
}
var seq = Seq(1,2,3)
println(checkElement(seq, 45)(_<3))
println(checkElement(seq, 1)(_<2))
}