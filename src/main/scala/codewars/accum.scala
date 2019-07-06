package codewars
object accum {

  def accum(s: String) = {
    s.zipWithIndex.map{ case (c, i) => c.toUpper + c.toLower.toString * i }.mkString("-")
}}