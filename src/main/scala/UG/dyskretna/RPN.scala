package UG.dyskretna

object RPN extends App {

  print(evaluate("52*2*6+"))
  def evaluate(expr :String) :Double = {
    val stack = collection.mutable.Stack[Double]()
    val list:List[Char]=List()
    expr.split(" ").foreach(x=> list :+ x  )
    list.foreach((x:Char)=>println(x))
    @annotation.tailrec
    def helper(asset :String) :Double =
      if (asset.isEmpty) stack.pop
      else {
        asset.head match {
          case c if c.isDigit =>
            stack.push(c.asDigit)
          case '+' => stack.push(stack.pop + stack.pop)
          case '-' => stack.push(-stack.pop + stack.pop)
          case '*' => stack.push(stack.pop * stack.pop)
          case '/' => stack.push(1/stack.pop * stack.pop)
          case  c  => throw new Error(s"Bad Char: $c")
        }
        helper(asset.tail)
      }

    helper(expr)
  }
}
