package contest1469

import org.scalatest.flatspec._
import org.scalatest.matchers._
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper

class BSpec extends AnyFlatSpec with should.Matchers {

  "B maxSum" should "return correct answer" in {
    B.maxSum(List(1, 2, -3)) mustBe 3
    B.maxSum(List(-1, 2, -3, 10)) mustBe 8
    B.maxSum(List(1, 2, 3, -2)) mustBe 6
  }

  "B f" should "return correct answer" in {
    B.f(List(-1 ,-2 ,-3, -4 ,-5),List(-1 ,-2, -3 ,-4 ,-5)) mustBe 0

  }


}
