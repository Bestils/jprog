package UG.cw7

object zadanie5 extends App {
  def freq[A](seq: Seq[A]): Map[A, Int] = {
    seq.groupBy((a: A) => a).mapValues((s: Seq[A]) => s.size)
  }
}
