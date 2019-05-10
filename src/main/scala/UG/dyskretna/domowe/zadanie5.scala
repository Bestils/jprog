package UG.dyskretna.domowe

import scala.collection.mutable

object zadanie5 extends App{





  def RPN(expr :String) :String ={



    val s1 = collection.mutable.Stack[Char]()// trzyma znaki
    val s2 = collection.mutable.Stack[Char]() // trzyma liczby
    val list:List[Char]=List()

    def helper(expr:Seq[String],stak1:collection.mutable.Stack[Char],stak2:collection.mutable.Stack[Char]) = expr match {
      case Seq() => ""
      case a+: r if a== "(" => helper(acc,r) // tworzymy nowe wywołanie funkcji dla całego pozostałego wyrtażenia od (
      case a+: r if a== ")" => return s1+s2+helper(acc,r) // zwracamy to co było w nawiasie i wywołujemy helpera dla reszty aby to scalić
      case a+: r if a >= 0  && a<= 9 => s2.push(a); helper(acc,r,s1,s2)
      case a+: r => s1.push(a); helper(acc,r,s1,s2)

    }
  }

//    def evaluate(expr :String) :Double = {
//      val stack = collection.mutable.Stack[Double]()
//      val list:List[Char]=List()
//      expr.split(" ").foreach(x=> list :+ x  )
//      list.foreach((x:Char)=>println(x))
//      @annotation.tailrec
//      def helper(asset :String) :Double =
//        if (asset.isEmpty) stack.pop
//        else {
//          asset.head match {
//            case c if c.isDigit =>
//              stack.push(c.asDigit)
//            case '+' => stack.push(stack.pop + stack.pop)
//            case '-' => stack.push(-stack.pop + stack.pop)
//            case '*' => stack.push(stack.pop * stack.pop)
//            case '/' => stack.push(1/stack.pop * stack.pop)
//            case  c  => throw new Error(s"Bad Char: $c")
//          }
//          helper(asset.tail)
//        }
//
//      helper(expr)
//    }
  }

//To even the odds - wyrównać szanse
//To ring a bell - przypominać coś już wcześniej napotkanego
//To do jack all - nie robić zupełnie nic
//To take a rain check - przełożyć coś w czasie
//As snug as a bug - jak u Pana Boga za piecem
//To blow the cobwebs away - zacząć na świeżo, od nowa

