package codewars

object ProdFib extends App{

  def productFib(prod: Long): Array[Long] = {


    def getProd(prod: Long,n : Int):Array[Long]= {



      if (giveFib(n) * giveFib(n + 1) < prod &&  prod < giveFib(n + 1) * giveFib(n + 1))  new Array[Long]{giveFib(n + 2),giveFib(n + 2),0}
      else  if (giveFib(n) * giveFib(n + 1)==prod)  tab={giveFib(n + 2),giveFib(n + 2),0)

    }

  def giveFib(n : Int):Int= n match {
    case 0 | 1 => n
    case _ => giveFib( n-1 ) + giveFib( n-2 )

  }  }


}
