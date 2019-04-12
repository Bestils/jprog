package codewars

object Tribonacci extends App {
  def tribonacci[T: Numeric](signature: List[T], n: Int): List[T] = n match {
case   2|1|0  => signature.takeRight(n)
    case 3 => signature
    case _ => tribonacci(signature :+ signature.takeRight(3).sum,n-1)

  }

}