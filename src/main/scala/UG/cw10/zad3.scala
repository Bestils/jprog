package UG.cw10

import scala.io.Source

object zad3  extends  App{

  val numbers: Seq[Int] = Source.fromFile("src\\laboratoria\\zadania\\liczby.txt").getLines.toList.
    map((s: String) => s.toInt)
  val result = (numbers.filter((n: Int) => n%2==0), numbers.filter((n: Int) => n%2 != 0))

}
