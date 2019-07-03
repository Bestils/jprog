package myWork


object Exceptions extends App {

  val x: String = null




// val fullArray : Array[Int] = Array.ofDim(Int.MaxValue )
//  def soe:Int=soe +1
//
//  println(soe)
}
class OverflowException extends RuntimeException
class UnderflowException extends RuntimeException
class MatchCalculationException extends RuntimeException

object PocketCalculator extends App{

  def add(x:Int,y:Int) ={
    val result = x+y
  if(result>Int.MaxValue)
    throw new OverflowException
    else if(x>0&&y>0&&result<0)
    throw new OverflowException
  else if(x<0&&y<0&&result>0)
    throw new UnderflowException
else result

  }
  def substract(x:Int,y:Int) = {
  val result =    x-y
    if(result<Int.MinValue)
      throw new UnderflowException
    else if(x>0&&y>0&&result<0)
      throw new OverflowException
    else if(x<0&&y<0&&result>0)
      throw new UnderflowException
    else result
  }
  def multiply(x:Int,y:Int) = {
    val result =    x-y
    if(result<Int.MinValue)
      throw new OverflowException
    else if(x>0&&y>0&&result<0)
      throw new OverflowException
    else if(x<0&&y<0&&result>0)
      throw new OverflowException
    else if(x<0&&y>0&&result<0)
      throw new OverflowException
    else if(x<0&&y>0&&result>0)
      throw new OverflowException
    else result
  }

  def divide(x:Int,y:Int) ={
    val result = x/y
  if(y==0)
    throw new MatchCalculationException
  else result
  }




    println(add(Int.MaxValue,6))


}
