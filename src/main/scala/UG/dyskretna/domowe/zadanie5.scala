package UG.dyskretna.domowe

import java.util

import scala.collection.mutable

object zadanie5 extends App{



  def isEmpty(x: String) = Option(x).forall(_.isEmpty)

  def RPN(expr :String) :String ={






 var patern ="*/-+^"

    def helper(expr:Seq[Char], acc:String, stak1:util.List[util.Stack[Char]], it:Int) :String = expr match {
      case Seq() if stak1.isEmpty=> acc
      case Seq() => helper(expr,acc+stak1.get(it).pop(),stak1,it)
      case a+: r if a== '(' => {
        stak1.add(new util.Stack())
        acc + helper(r, "", stak1, it + 1)
      }
        // tworzymy nowe wywołanie funkcji dla całego pozostałego wyrtażenia od (
      case a+: r if a== ')' && stak1.get(it).isEmpty => {
        stak1.remove(stak1.size() - 1)
        acc+helper(r,"",stak1,it-1)}

        // zwracamy to co było w nawiasie i wywołujemy helpera dla reszty aby to scalić
      case a+: r if a== ')' => {

        helper(expr, acc:+stak1.get(it).pop(), stak1, it) // zwracamy to co było w nawiasie i wywołujemy helpera dla reszty aby to scalić}

      }
      case a+: r if !patern.contains(a) =>  helper(r,acc+Character.toString(a),stak1,it)


      case a+: r  if stak1.isEmpty()=> { stak1.add(new util.Stack())
       stak1.get(it).push(a)

        helper(r,acc,stak1,it)}
    }

    helper(expr.toCharArray.toSeq,"",new  util.ArrayList( new util.Stack()),0)
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


//To even the odds - wyrównać szanse
//To ring a bell - przypominać coś już wcześniej napotkanego
//To do jack all - nie robić zupełnie nic
//To take a rain check - przełożyć coś w czasie
//As snug as a bug - jak u Pana Boga za piecem
//To blow the cobwebs away - zacząć na świeżo, od nowa

