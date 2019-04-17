package UG.cw6_old

object zadanie4 extends App{

//  Stwórz generyczną funkcję rekurencyjną:
  //def compress[A](seq: Seq[A]): Seq[(A, Int)] = /* ... */
  //która zastąpi każdy element sekwencji seq parą
  // (element, długość_podciągu) Zdefiniuj funkcję z użyciem rekurencji ogonowej.
  //Przykład:
  //Dla: seq = Seq('a', 'a', 'b', 'c', 'c', 'c', 'a', 'a', 'b', 'd'), funckja powinna zwrócić:
  // Seq(('a',2), ('b', 1), ('c', 3), ('a', 2), ('b', 1), ('d', 1)).
  def compress[A](seq: Seq[A]): Seq[(A, Int)] = {

    def compressHelper[A](seq: Seq[A],acc:Seq[(A, Int)],count:Int ): Seq[(A, Int)] = seq match{
      case Seq() => acc
      case  a :+ b :+ s if a==b => compressHelper(b:+s,)


    }
  }
}
//21708623