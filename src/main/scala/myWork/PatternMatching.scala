package myWork

object PatternMatching extends App{

  trait Expr
  case class Number(x:Int) extends Expr
  case class Sum(e1:Expr,e2:Expr) extends Expr
  case class Prod(e1:Expr,e2:Expr) extends Expr

  def shown(a:Expr) :String =a match {
    case Number(n) => s" its $n"
    case Sum(x,y) => s"$x + $y is equal "+x+y
    case Prod(x,y) =>{
      def maybeShowParentheses(expr: Expr) = expr match {
        case Prod(_,_) => shown(expr)
        case  Number(_) => shown(expr)
        case _ => "(" + shown(expr) + ")"
      }
      maybeShowParentheses(x) + " * " + maybeShowParentheses(y)
    }

  }
}
