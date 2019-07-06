package codewars

import org.scalatest.FunSuite
import org.scalatest.FunSpec
class accumTest  extends FunSpec {
    describe("Codewars.accum") {
      it("should work with example tests") {
        assertResult ("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu") {accum.accum("ZpglnRxqenU")}
        assertResult ("N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb") {accum.accum("NyffsGeyylB")}
        assertResult ("M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu") {accum.accum("MjtkuBovqrU")}
        assertResult ("E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm") {accum.accum("EvidjUnokmM")}
        assertResult ("H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc") {accum.accum("HbideVbxncC")}
      }
    }



}
