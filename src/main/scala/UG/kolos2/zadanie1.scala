package UG.kolos2

import scala.io.Source

object zadanie1 extends App{

  val numbers: Seq[Int] = Source.fromFile("src\\main\\zadania\\liczby.txt").getLines.toList.
    map((s: String) => s.toInt)
  val result = (numbers.filter((n: Int) => n%2==0), numbers.filter((n: Int) => n%2 != 0))

}
