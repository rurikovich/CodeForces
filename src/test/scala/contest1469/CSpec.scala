package contest1469

import org.scalatest.flatspec._
import org.scalatest.matchers._
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper

class CSpec extends AnyFlatSpec with should.Matchers {

  "C check" should "return correct answer" in {
    C.check(6, 3, List(0, 0, 2, 5, 1, 1)) mustBe true
    C.check(2, 3, List(0, 2)) mustBe true
    C.check(3, 2, List(3, 0, 2)) mustBe false

    C.check(20, 3, List(7, 7, 5, 3, 2, 2, 7, 7, 7, 10, 5, 0, 8, 1, 5, 8, 6, 6, 8, 1)) mustBe false

  }


}
