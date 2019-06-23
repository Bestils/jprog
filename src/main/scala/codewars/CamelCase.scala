package codewars

object CamelCase extends App {

  def toCamelCase(str: String): String = {


    val splited = str.split("[-_]")
    if (str.isEmpty )
    ""
    else
    (splited.head +
      splited.map(x => x.head.toUpper + x.tail).tail.mkString).mkString.trim()

  }
}
