package UG.kolos1

object wp {

  //package d_ho_functions
  //
  //object Main extends App {
  //  val f: Int => Int = ???                 // f: Int -> Int
  //  val g: (Int, String) => String = ???    // g: Int x String -> String
  //  val h: (Int, (String, Int => Boolean) => Int) => (Int => Int) = ??? // :)
  //
  //  //=====================================================================
  //  // Funkcje „wyższego rzędu” – spełniające co najmniej jeden z warunków:
  //  //  – co najmniej jeden parametr jest typu funkcyjnego
  //  //  – wynik jest typu funkcyjnego
  //  //=====================================================================
  //  def parzyste(t: Array[Int]): Array[Int] = {
  //    @annotation.tailrec
  //    def helper(t: Array[Int], result: Array[Int]): Array[Int] = {
  //      if (t.isEmpty) result
  //      else {
  //        if (t(0) % 2 == 0) helper(t.drop(1), result :+ t(0))
  //        else helper(t.drop(1), result)
  //      }
  //    }
  //    helper(t, Array.emptyIntArray)
  //  }
  //  val tab = Array(1,2,3,4,5)
  //  // Użyte powyżej metody/operacje tablicowe:
  //  // tab.isEmpty  ==> false
  //  // tab.drop(1)  ==> Array(2,3,4,5)
  //  // tab :+ 6     ==> Array(1,2,3,4,5,6)
  //  // 0 +: tab     ==> Array(0,1,2,3,4,5)
  //  println(parzyste(tab).mkString("[", ",", "]"))
  //
  //  // jeśli interesują nas elementy nieparzyste
  //  def nieparzyste(t: Array[Int]): Array[Int] = {
  //    @annotation.tailrec
  //    def helper(t: Array[Int], result: Array[Int]): Array[Int] = {
  //      if (t.isEmpty) result
  //      else {
  //        if (t(0) % 2 != 0) helper(t.drop(1), result :+ t(0))
  //        else helper(t.drop(1), result)
  //      }
  //    }
  //    helper(t, Array.emptyIntArray)
  //  }
  //  println(nieparzyste(tab).mkString("[", ",", "]"))
  //
  //  // można zatem ogólniej:
  //  def pasujące(t: Array[Int], pred: Int => Boolean): Array[Int] = {
  //    @annotation.tailrec
  //    def helper(t: Array[Int], result: Array[Int]): Array[Int] = {
  //      if (t.isEmpty) result
  //      else {
  //        if (pred(t(0))) helper(t.drop(1), result :+ t(0))
  //        else helper(t.drop(1), result)
  //      }
  //    }
  //    helper(t, Array.emptyIntArray)
  //  }
  //  // nieparzyste
  //  println(pasujące(tab, n => n %2 != 0).mkString("[", ",", "]"))
  //  // większe od 2
  //  println(pasujące(tab, n => n > 2).mkString("[", ",", "]"))
  //
  //  // A teraz funkcja jako wynik:
  //  def filtruj(t: Array[Int]): (Int => Boolean) => Array[Int] = {
  //    pred => pasujące(t, pred)
  //  }
  //  //---------------------------------------------------------------------
  //  // „curryfikacja” funkcji (Haskell Curry [1900-1982])
  //  //---------------------------------------------------------------------
  //  // najpierw z użyciem lambda-wyrażeń (literałów funkcyjnych)
  //  val dodawacz = (x: Int) => (y: Int) => x + y  // : Int => (Int => Int)
  //  val plus2 = dodawacz(2)
  //
  //  // teraz „normalna” definicja – z użyciem „def”
  //  def dodaj(x: Int)(y: Int): Int = x + y
  //  // i rózne sposoby jej użycia (również z def)
  //  def dodaj5: Int => Int = dodaj(5)
  //  def dodaj4 = n => dodaj(4)(n)
  //  def dodaj3 = dodaj(3) _
  //
  //  // jeszcze jeden przykład
  //  def appl(f: (Int, Int) => Int, a: Int, b: Int): Int = f(a, b)
  //  appl(_*_, 3, 4)
  //
  //  // a teraz dzielimy listę parametrów na „grupy”
  //  def currAppl(f: (Int, Int) => Int)(a: Int)(b: Int): Int = f(a, b)
  //  val fun = currAppl(_ + _)(2)(_)
  //
  //  def formater(fmt: String)(d: Double): String = fmt.format(d)
  //  val fmt42 = formater("%4.2f") _
  //
  //  //---------------------------------------------------------------------
  //  // Funkcje „polimorficzne”/„generyczne”
  //  //---------------------------------------------------------------------
  //  def id(n: Int): Int = n
  //  // i w wersji generycznej:
  //  def id[A](a: A): A = a
  //
  //  // nieco bardziej życiowy przykład
  //  def findFirst(ss: Array[String], key: String): Int = {
  //    @annotation.tailrec
  //    def loop(n: Int): Int =
  //      if (n >= ss.length) -1
  //      else if (ss(n) == key) n
  //      else loop(n + 1)
  //    loop(0)
  //  }
  //
  //  // Powyższa definicja w zasadzie nie zależy od tego,
  //  // że tablica przechowuje napisy. Możemy więc:
  //  def findFirst[A](aa: Array[A], key: A): Int = {
  //    @annotation.tailrec
  //    def loop(n: Int): Int =
  //      if (n >= aa.length) -1
  //      else if (aa(n) == key) n
  //      else loop(n + 1)
  //    loop(0)
  //  }
  //
  //  // Filtrowanie generyczne
  //  def genFilter[A](t: Seq[A])(pred: A => Boolean): Seq[A] = {
  //    @annotation.tailrec
  //    def helper(t: Seq[A], result: Seq[A]): Seq[A] = {
  //      if (t.isEmpty) result
  //      else {
  //        if (pred(t.head)) helper(t.tail, result :+ t.head)
  //        else helper(t.drop(1), result)
  //      }
  //    }
  //    helper(t, Seq())
  //  }
  //  // Seq[A] zamiast Array[A] ponieważ tablice są specyficzne
  //  // gdyż pochodzą wprost z JVM. Dla nich musielibyśmy zdefiniować
  //  // genFilter[A:ClassTag](...): Array[A] = ???
  //
  //  println(genFilter(tab)(n => n < 3))
  //
  //}
}
