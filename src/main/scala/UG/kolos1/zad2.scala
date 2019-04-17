package UG.kolos1

object zad2 extends App {

def initPairMap[A,B,C](seq:Seq[A])(op1:(A)=>B)(op2:(A)=>C): Seq[(B,C)] = {
    def helper[A,B,C](seq:Seq[A])(op1:(A)=>B)(op2:(A)=>C)(acc:Seq[(B,C)]): Seq[(B,C)] = {
        (seq) match{
            case (Seq()) => acc
            case (a1 +: Seq()) => acc
            case (a1 +: seq) => helper(seq)(op1)(op2)(acc :+ (op1(a1),op2(a1)))
        }
    }
helper(seq)(op1)(op2)(Seq())
}
var seq = Seq(1,2,3,4,5)
println(initPairMap(seq)(_*2)(_*3))
}