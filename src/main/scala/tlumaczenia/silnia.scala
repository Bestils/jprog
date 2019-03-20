package tlumaczenia

import scala.annotation.tailrec

object silnia extends App{

  def silnia (n: Int): Int = if (n <=1) 1
  else
    {println("Aby wyliczyć silnie z "+ n+"pierw musze policzyc silni z "+(n-1))// pokazanie jak leci  silnia od góry aż do dołu
    val wynik = n* silnia(n-1)
      println("obliczalnie silni z "+ n)
      wynik

    }

  def lepszaSilna(n:Int):Int ={
    def silnyPomocnik(x: Int, akumulator : Int): Int =
      if( x<= 1)akumulator
      else silnyPomocnik(x-1,x*akumulator)

    silnyPomocnik(n,1)
  }
  /*
    lepszaSilna(10) = silnyPomocnik(10, 1)
    = silnyPomocnik(9, 10 * 1)
    = silnyPomocnik(8, 9 * 10 * 1)
    = silnyPomocnik(7, 8 * 9 * 10 * 1)
    = ...
    = silnyPomocnik(2, 3 * 4 * ... * 10 * 1)A
    = silnyPomocnik(1, 1 * 2 * 3 * 4 * ... * 10)
    = 1 * 2 * 3 * 4 * ... * 10
    to działa bo się nie nakłada na stack jak poprzednio bo nie musi wracać(wynik jest gotowy przy ostatnim wykonaniu -> stack jest zbędny )  przez co mamy tylko wywołania  funkcji

   */

  //  println(factorial(5000))

  def jeszczeLepszaSilna(n: Int): BigInt = {
    @tailrec // TAIL RECURSION = użyj wywołania rekursji  jako wyrażenia LAST
    def silnyPomocnik(x: Int, akumulator: BigInt): BigInt =
      if (x <= 1) akumulator
      else silnyPomocnik(x - 1, x * akumulator)

    silnyPomocnik(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)A
    = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
    = 1 * 2 * 3 * 4 * ... * 10

   */


  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  /*
    1.  Concatenate a string n times
    2.  IsPrime function tail recursive
    3.  Fibonacci function, tail recursive.
   */

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)



  silnia(10)
  silnia(5000)

}
