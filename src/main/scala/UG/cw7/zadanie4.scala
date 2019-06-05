package UG.cw7

object zadanie4 extends App{
  def remElems[A](seq: Seq[A], k: Int): Seq[A] = {seq.zipWithIndex.filter((pair:(A,Int)) =>pair._2 !=k).map((pair: (A, Int)) => pair._1)}
}
