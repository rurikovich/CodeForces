package contest1469

import org.scalatest.flatspec._
import org.scalatest.matchers._
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper

class ASpec extends AnyFlatSpec with should.Matchers {

  "A " should "return correct answer" in {
    A.checkStr("()") mustBe true
    A.checkStr("(?)") mustBe false
    A.checkStr("(??)") mustBe true
    A.checkStr("??()") mustBe true
    A.checkStr(")?(?") mustBe false

    A.checkStr("?)?(") mustBe false


  }


}
