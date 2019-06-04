package UG.cw7

object zadanie1 extends App{
  def subseq[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] = {

    def helper[A](i:Int,acc :Seq[A],seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A]=seq match {
    case Seq()=> acc
    case Seq(a) if (i>=begIdx && i<=endIdx) => acc:+a
    case a +:r  if (i>=begIdx && i<=endIdx)  => helper(i+1,acc:+a,r,begIdx,endIdx)
    case a +:r  if ( i>endIdx)  => acc
    case a +:r  => helper(i+1,acc,r,begIdx,endIdx)

    }
    helper(0,Seq(),seq,begIdx,endIdx)

  }
  def subseq2[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] = {
    seq.drop(begIdx).take(endIdx-begIdx+1)

  }
  val seq =Seq("łukasz","nie","ma","serca")

  println(subseq(seq,0,0))
  println(subseq2(seq,0,0))
  }




  //. Korzystając z metod drop i take zdefiniuj generyczną funkcję:
  //def subseq[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] = /* ... */
  //która zwraca podciąg ciągów sekwencji seq z przedziału od indeksu begIdx do endIdx.



