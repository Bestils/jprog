package UG.cw8

import java.util.Optional

object Zadanie2 extends  App{
//Korzystając z metod oferowanych przez kolekcje zipWithIndex i foldLeft zdefiniuj funkcję:
  //def position[A](seq: Seq[A], el: A): Option[Int] = /* ... */
  //która zwróci pierwszy indeks w ciągu seq, na którym znajduje się element el. W przypadku braku elementu, powinno zostać zwrócone None,
  //Przykład:
  //Dla: seq = Seq(2, 1, 1, 5), el = 1, funkcja powinna zwrócić: Some(2).
  //Dla: seq = Seq(2, 1, 1, 5), el = 7, funkcja powinna zwrócić: None.

  def position2[A](seq: Seq[A], el: A):Int= {
    seq.zipWithIndex.filter((pair:(A,Int))=> pair._1 == el).head._2



  }
  def position[A](seq: Seq[A], el: A):Int= {





  def indexes(seq: Seq[A],el : A)=
    {seq.zipWithIndex collect {
      case (i,x) if (i== el) => (x)

    }}
    if(indexes(seq,el).isEmpty){
      return -1
    }
    else{
      return indexes(seq,el).head
    }

  }




val  seq = Seq(2, 1, 1, 5)
  val el = 1

  println(position(seq,el))
  println(position2(seq,el))
}
