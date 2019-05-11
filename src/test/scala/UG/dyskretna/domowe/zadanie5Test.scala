package UG.dyskretna.domowe

import UG.dyskretna.domowe.zadanie5Test._
import org.scalatest.Assertions._
import org.scalatest._


class zadanie5Test extends FlatSpec {
  it should "pass basic tests" in {
    testing("(a+(b*c))",  "abc*+")
    testing("((a+b)*(z+x))",  "ab+zx+*")
    testing("((a+t)*((b+(a+c))^(c+d)))",  "at+bac++cd+^*")

  }
}

object zadanie5Test {

  private def testing(n: String,  expect: String): Unit = {
    println("Testing: " + n )
    val actual: String = zadanie5.RPN(n)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("*")
    assertResult(expect){actual}
  }
}
