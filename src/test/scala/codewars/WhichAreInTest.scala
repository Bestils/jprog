package codewars

import org.scalatest._
import org.scalatest.Assertions._

import WhichAreInTest._

class WhichAreInTest extends FlatSpec {
  it should "pass basic tests" in {
    var a1 = Array("live", "arp", "strong")
    var a2 = Array("lively", "alive", "harp", "sharp", "armstrong")
    var r = Array("arp", "live", "strong")
    testing(a1, a2, r)

  }
}

object WhichAreInTest {
  private def testing(array1: Array[String], array2: Array[String], expect: Array[String]): Unit = {
    val actual: Array[String] = WhichAreIn.inArray(array1, array2)
    assertResult(expect){actual}
  }
}
