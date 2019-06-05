package UG.cw10

import scala.io.Source

object zad2  extends  App{

  val names: Seq[String] = Source.fromFile("src\\laboratoria\\zadania\\osoby.txt").getLines.toList
  val mappedNames =  names.groupBy((s: String) => s.length - 1)
}
