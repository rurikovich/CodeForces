package contest1469


object A extends App {

  val n = scala.io.StdIn.readInt()

  for (_ <- 0 until n) {
    val s = scala.io.StdIn.readLine()
    if (checkStr(s)) println("YES") else println("NO")
  }


  def checkStr(s: String): Boolean = {
    val n = s.length
    val bracket1 = s.indexOf("(")
    val bracket2 = s.indexOf(")")

    val correctBracketOrder = bracket1 < bracket2

    val (a, b, c) = if (correctBracketOrder) {
      val a = bracket1
      val c = n - bracket2 - 1
      val b = n - a - c - 2

      (a, b, c)
    } else {
      val a = bracket2
      val c = n - bracket1 - 1
      val b = n - a - c - 2

      (a, b, c)
    }


    (n, a, b, c) match {
      case (n, _, _, _) if n % 2 != 0 => false
      case (n, a, _, c) if n % 2 == 0 && !correctBracketOrder && (a == 0 || c == 0) => false
      case _ => true
    }


  }

}
