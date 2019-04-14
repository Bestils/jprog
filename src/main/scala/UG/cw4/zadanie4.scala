package UG.cw4

object zadanie4 extends App{
  def size[A](a: Seq[A]): Int ={


    def sizeReqTail[A](seq:Seq[A],n:Int):Int=seq match{
      case Seq() =>n
      case _ => sizeReqTail(seq.tail,n+1)
    }

    sizeReqTail(a,0)
  }

  def size2[A](a: Seq[A]): Int ={

    def sizeReq[A](seq:Seq[A]):Int=seq match{
      case Seq() =>0
      case _ => sizeReq(seq.tail)+1
    }

    sizeReq(a)
  }


  var seq = Seq(123,123,123,122,12)
  println(size(seq))
}
//21708623