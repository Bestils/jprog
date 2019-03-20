package codewars
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ListBuffer

object Kata {
  def removeEveryOther[T](list: List[T]): List[T] = {
    list.zipWithIndex collect { case (x,i) if (i + 1) % 2 != 0 => x }
}

}
