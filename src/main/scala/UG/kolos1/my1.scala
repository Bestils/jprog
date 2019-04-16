package UG.kolos1

object my1 extends App {
  def lengthStrings(seq1: Seq[String], seq2: Seq[String]): Int = {
    def helper(seq: (Seq[String], Seq[String]), acc: Int): Int = seq match {
      case (Seq(), Seq()) => acc
      case (a +: r1, Seq()) => acc
      case (Seq(), b +: r2) => acc
      case (a +: r1, b +: r2) if a.length == b.length => (helper((r1, r2), acc + 1))
      case (a +: r1, b +: r2) => (helper((r1, r2), acc))


    }

    helper((seq1, seq2), 0)
  }

  var seq1 = Seq("aaa", "bbb", "po", "papa", "papa", "papa")
  var seq2 = Seq("aa", "aba", "pa", "pop")

println(lengthStrings(seq1,seq2))
  //1 to było podaj ile ciągów ma taką samą długość

  //2 zwróć  2 seq jeden x2 drugi x3
  //3 sprawdz czy elemend pod danym indekstem w seq spełnia leq
}