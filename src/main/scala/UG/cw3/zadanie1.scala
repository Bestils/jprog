package UG.cw3

object zadanie1 {
//Zadanie 1. Stwórz rekurencyjną funkcję odwroc(str: String): String, która zwróci odrócony napis pobrany jako argument. Rozwiąż to zadanie bez korzystania ze zmennych oraz wykorzystaj rekurencję ogonową.

  def palindrom(napis: String) : Unit ={


    def reverse[A](l: List[A]): List[A] = l match {
      case h :: tail => reverse(tail) ::: List(h)
      case Nil => Nil
    }

    reverse(napis.toList)
  }

}
