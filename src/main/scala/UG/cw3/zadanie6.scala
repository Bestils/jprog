package UG.cw3

import UG.cw3.zadanie6.printRow

object zadanie6 extends App{
//Zadanie 6. Stwórz rekurencyjną funkcję trojkat(n: Int): Unit, która wyświetli trójkąt o wysokości n taki, że bo bokach trójkąta liczba bedą znajdywały się wartości 1, natomiast wewnątrz trójkąta suma liczby znajdującej się po "prawej" i "lewej" stronie znajdujących się w poprzednim wierszu.
  //Przykład dla n=5
  //        1
  //      1   1
  //    1   2   1
  //  1   3   3   1
  //1   4   6   4   1
  //Rozwiąż to zadanie bez korzystania ze zmennych oraz wykorzystaj rekurencję ogonową.


  printTriangle(10)
  def printTriangle(n: Int): Unit = {
    def printTriangleAux(n: Int, values: Array[Int] = Array(1)): Unit = {
      if(values.length <= n) {
        printSpace(n-values.length+1)
        printRow(values)

        println()
        printTriangleAux(n, recalculate(values) :+ 1)
      }
    }
    printTriangleAux(n)
  }

  def printRow(values: Array[Int]): Unit = {
    if(values.length != 0) {
      print(values.head)
      if(values.length != 1) print("   ")
      printRow(values.tail)
    }



        }
  def printSpace(t:Int): Unit = {
    if(t < 2) {
      print("")}
    else  {
      print("  ")
    printSpace(t=t-1)
      } }


  def recalculate(values: Array[Int]): Array[Int] = {
    val temp = new Array[Int](values.length)
    temp(0) = 1
    var i = 1
    while(i < temp.length) {
      temp(i) = values(i) + values(i-1)
      i += 1
    }
    temp //return
  }
}
