//package UG.cw6
//
//object zadanie4 extends App{
//
//// . Stwórz generyczną funkcję rekurencyjną:
//  //def compute[A,B](seq: Seq[A])(init: B)(op: (A, B) => B): B = /* ... */
//  //która korzystając z wartości początkowej oraz funkcji op oblicz "wartość" ciągu s. Zdefiniuj funkcję z użyciem rekurencji ogonowej.
//  //Przykłady:
//  //Dla: seq = Seq(1,2,3,4), init = 0, op = (_ + _), funckja powinna zwrócić: 10.
//  //Dla: seq = Seq(1,2,3,4), init = 1, op = (_ * _), funckja powinna zwrócić: 24.
//  //Dla: seq = Seq("kota"," ","ma"," ","ala"), init = "", op = (_ + _), funckja powinna zwrócić: "ala ma kota".
//
//  def compute[A,B](seq: Seq[A])(init: B)(op: (A, B) => B): B ={
//
//    def helper[A,B](seq: Seq[A])(init: B)(op: (A, B) => B): B = seq match{
//      case Seq(a) => acc
//      case a +:b+: r => helper(op(a,b)+:r)(op)
//
//    }
//  }
//
//}
////21708623