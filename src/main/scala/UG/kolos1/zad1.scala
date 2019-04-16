package UG.kolos1

object zad1 extends App {
    
    def lengthStrings(seq1:Seq[String], seq2:Seq[String]): Int = {
        def helper(seq:(Seq[String],Seq[String]), acc: Int): Int =
            (seq) match {
                case (Seq(),Seq()) => acc
                case (a1 +: seq1, a2 +:seq2) if (a1.length==a2.length) => helper((seq1,seq2), acc+1)
                case (a1 +: seq1, a2 +:seq2) => helper((seq1,seq2), acc)
            }

    helper((seq1,seq2), 0)
    }
var seq1 = Seq("aaa","bbb","po","papa")
var seq2 = Seq("aa","aba","pa","pop")
println(lengthStrings(seq1, seq2))

}