package UG.cw3

object zadanie5 extends App{
//Zadanie 5. Stwórz rekurencyjną funckję ciag(n: Int): Int, która zwróci n-ty wyrażony wzorem:
  //F(0) = 1
  //F(1) = 1
  //F(n) = F(n-1) + F(n-2) dla n > 1
  //Rozwiąż to zadanie bez korzystania ze zmennych oraz wykorzystaj rekurencję ogonową.
  //Pierwsze 10 wyrazów ciągu: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.


  def giveFib(n : Int):Int= n match {
    case 0 | 1 => n
    case _ => giveFib( n-1 ) + giveFib( n-2 )

  }

}
