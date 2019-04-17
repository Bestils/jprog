package UG.cw6

object zadanie1 extends App{
// Stwórz generyczną funkcję rekurencyjną:
//def applyForAll[A,B](seq: Seq[A], f: A => B): Seq[B] = /* ... */
//która dla wszystkich elementów seq stosuje funckję f. Zdefiniuj funkcję z użyciem rekurencji ogonowej.
//Przykład:
//Dla: seq = Seq(1, 3, 5) i f = (n) => n + 3 , funckja powinna zwrócić: Seq(4, 6, 8).
def applyForAll[A,B](seq: Seq[A], f: A => B): Seq[B] = {

  def helper [A,B](seq: Seq[A],acc:Seq[B], f: A => B): Seq[B] = seq match {
    case  Seq() => acc
    case a+:r => helper(r,acc :+ f(a),f)


  }

  helper(seq,Seq(),f)
}

  var  seq = Seq(1, 3, 5)
  var f ={n:Int =>n+3}
 applyForAll(seq, f)

}
