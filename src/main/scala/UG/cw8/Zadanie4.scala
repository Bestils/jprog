package UG.cw8

object Zadanie4 extends App{
//Korzystając z metod oferowanych przez kolekcje trawersowalne (Traversable[A]) zdefiniuj funkcję:
  //def swap[A](seq: Seq[A]): Seq[A] = /* ... */
  //która zamieni kolejnością wartości znajdujących się na parzystych i nieprarzystych indeksach.
  //Przykład:
  //Dla: seq = Seq(1, 2, 3, 4, 5), Seq(2, 1, 4, 3, 5).
//  var seq = Seq(1,3)
//  println(seq)
//  def swap[A](seq: Seq[A]): Seq[A] ={
//
//  def swapHelper[A](seq: Seq[A],n: Int): Seq[A]={
//
//
//  }}
  def swap[A](seq: Seq[A]): Seq[A] ={
  def divide(seq: Seq[A]) :(Seq[(A, Int)], Seq[(A, Int)]) ={
    seq.zipWithIndex.partition((pair:(A,Int))=>pair._2%2==1)


    }
    val seq1= divide(seq)._1.map((pair: (A, Int)) => pair._1)
    val seq2= divide(seq)._2.map((pair: (A, Int)) => pair._1)
    def helper(seq1: Seq[A],seq2: Seq[A],i:Int,acc:Seq[A]):Seq[A]=(seq1,seq2) match{
      case (Seq(),Seq()) => acc
      case (Seq(),Seq(a)) => acc:+a
      case _ if i%2==0 => helper(seq1.tail,seq2,i+1,acc:+seq1.head)
      case _  => helper(seq1,seq2.tail,i+1,acc:+seq2.head)    }

    helper(seq1,seq2,0,Seq())
  }

  val seq = Seq(1, 2, 3, 4, 5)
  println(swap(seq))
}
