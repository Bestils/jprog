package codewars

object Tribonacci extends App {
  def tribonacci[T: Numeric](signature: List[T], n: Int): List[T] = n match {

    case 0 => signature
    case _ => signature :+ signature.take(3).sum

  }

}