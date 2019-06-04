package UG.cw7

object zadanie6 extends App{
  def countChars(str: String): Int = {
    str.groupBy((a: Char) => a).size
  }


}
