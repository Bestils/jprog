package UG.kolos1.lmielewczyk

object zad1 extends App {

  def notDifferentElements[A](seq1:Seq[A], seq2:Seq[A]): Seq[A] = {
    def helper(seq:(Seq[A],Seq[A]), acc: Seq[A]): Seq[A] =
      (seq) match {
        case (Seq(),Seq()) => acc
        case (a1 +: seq1,Seq()) => acc
        case (Seq(),a2 +: seq2) => acc
        case (a1 +: seq1, a2 +:seq2) if (a1==a2) => helper((seq1,seq2),acc:+a1)
        case (a1 +: seq1, a2 +:seq2)  => helper((seq1,seq2),acc)
      }

    helper((seq1,seq2), Seq())
  }
  var seq1 = Seq(1,2,3,2,4)
  var seq2 = Seq(3,2,3,5,1)
  println(notDifferentElements(seq1, seq2))

}
