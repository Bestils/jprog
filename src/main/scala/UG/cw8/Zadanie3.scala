package UG.cw8

object Zadanie3 {
//Zadanie 3. Korzystając z metod oferowanych przez kolekcje trawersowalne (Traversable[A]) zdefiniuj funkcję:
  //def indices[A](seq: Seq[A], el: A): Set[Int] = /* ... */
  //która zwróci wszystkie indeksy w ciągu seq, na których znajduje się element el.
  //Przykład:
  //Dla: seq = Seq(1, 2, 1, 1, 5), el = 1, funkcja powinna zwrócić: Set(0, 2, 3).
  //Dla: seq = Seq(1, 2, 1, 1, 5), el = 7, funkcja powinna zwrócić: Set().


  def position2[A](seq: Seq[A], el: A): Seq[Int]= {
    seq.zipWithIndex.filter((pair:(A,Int))=> pair._1 == el).map(pair => pair._2)



  }


  def indices[A](seq: Seq[A], el: A): Set[Int] ={

    def helper(seq: Seq[A], el: A , i : Int , acc : Set[Int]):Set [Int] = seq match {


      case Seq() => acc
      case a +: r if a==el => helper(r,el,i+1,acc+i)
      case a +: r => helper(r,el,i+1,acc)


    }
    helper(seq,el,0,Set())


//
//    seq.zipWithIndex.filter((a,b),a==el)=>b

  }






}
