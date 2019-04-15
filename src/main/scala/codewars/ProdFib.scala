package codewars

object ProdFib extends App{

  def productFib(prod: Long): Array[Long] = {
    def giveFib(n : Int):Int= n match {
      case 0 | 1 => n
      case _ => giveFib( n-1 ) + giveFib( n-2 )

    }

    def getProd(prod: Long,n : Int):Array[Long]= {

      if (giveFib(n) * giveFib(n + 1) < prod &&  prod < giveFib(n + 1) * giveFib(n + 1))   Array[Long](giveFib(n + 1),giveFib(n + 2),0)
      else  if (giveFib(n) * giveFib(n + 1)==prod)  Array[Long](giveFib(n ),giveFib(n + 1),1)
        else getProd(prod,n+1)

    }

getProd(prod,1)

  }

println(productFib(40).deep.mkString("\n"))
}
