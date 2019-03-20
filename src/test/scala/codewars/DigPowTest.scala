package codewars

import codewars.DigPowTest._
import org.scalatest.Assertions._
import org.scalatest._

class DigPowTest extends FlatSpec {
  it should "pass basic tests" in {
    testing(89, 1, 1)
    testing(92, 1, -1)
    testing(46288, 3, 51)

  }
}

object DigPowTest {

  private def testing(n: Int, p: Int, expect: Int): Unit = {
    println("Testing: " + n + ", " + p)
    val actual: Int = DigPow.digPow(n, p)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("*")
    assertResult(expect){actual}
  }
}
