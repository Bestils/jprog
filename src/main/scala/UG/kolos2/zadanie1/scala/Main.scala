package UG.kolos2.zadanie1.scala

object Main extends App {
  import scala.io.Source

  val dane = Source.fromResource("napisy.txt").getLines.toList
  
}
