package codewars

object AreTheySame extends App {
  def comp(seq1: Seq[Int], seq2: Seq[Int]): Boolean = {

    if (seq1 == null || seq2 == null)
      return false
    else
      seq1.map(x => x * x).sortWith(_ < _).toString() == seq2.sortWith(_ < _).toString()


  }

  def orderedCount(chars: String)= {
    println(chars.distinct)

  }

  println(points(Vector("st:rtr","tryr:t")))
  def points(games: Vector[String]): Int =
    games
      .collect {
        case x if x(0) > x(2)  => 3
        case x if x(0) == x(2) => 1
      }
      .sum

}




