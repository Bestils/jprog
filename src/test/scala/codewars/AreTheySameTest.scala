package codewars

import org.scalatest.FunSuite

class AreTheySameTest extends FunSuite {
  test("Example Test") {
    val seq1 = Seq(121, 144, 19, 161, 19, 144, 19, 11)
    val seq2 = Seq(11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19)
    assert(
      AreTheySame.comp(seq1, seq2) == true,
      s"\ncomp(${seq1}, ${seq2}) should be true"
    )
  }
}
