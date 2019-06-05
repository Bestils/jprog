package UG.cw10

import scala.io.Source

object zad4  extends  App{

  val instances: Int = Source.fromFile("src\\laboratoria\\zadania\\cyfry.txt").getLines.toList.
    map((s: String) => s.toList.map((c: Char) => (c + "").toInt)).foldLeft(0)((i: Int, seq: Seq[Int]) => i + f(seq)())

  def f(seq: Seq[Int], j: Int = 0)(isSeq: Boolean = false): Int = seq match {
    case Seq() => j
    case e1 +: e2 +: s if e1 < e2 && isSeq => f(e2 +: s, j)(isSeq = true)
    case e1 +: e2 +: s if e1 < e2 => f(e2 +: s, j+1)(isSeq = true)
    case _ +: s if isSeq => f(s, j)(isSeq = false)
    case _ +: s => f(s, j)()
}}
//mapowanie  x->y gdzie x to długość ciągów a y to ich ilość
//zadanie drugie :
//tworzycie Wychowawce wychowaca startuje z Init
// (liczba uczniów,liczba nauczycieli)
// tworzy tylu uczniów i nauczycieli po czym wysyła nauczycielowi uczniów .
// Nauczyciel wysyła pytania uczniom, uczeń wysyła odpowiedzi nauczycielowi
// ten je ocenia i wysyła wynik wychowawcy który oceny zapisuje
// i dopiero wtedy kolejnemu nauczycielowi wysyła uczniów .
// na sam koniec trzeba napisać jaka była średnia ocena


//zad1  macie pliczek liczby.txt  zawierający liczby w systemie dwójkowym
//macie przy pomocy kolekcji  podać : ile jest liczb parzystej długości
//ile jest liczb składających się z samych 1
//ile jest liczb z taką samą ilością 0 i 1