package round670

object A extends App {
  import scala.collection.mutable

  val t = scala.io.StdIn.readInt()

  for (_ <- (0 until  t)) {
    val n = scala.io.StdIn.readInt()

    val arrStr = scala.io.StdIn.readLine()
    val stdInArr = arrStr.split(" ").map(_.toInt)

    val intMap = mutable.Map.empty[Int, Int]

    for (a <- stdInArr) {
      intMap.put(a, intMap.getOrElse(a, 0) + 1)
    }

    var mexSum = 0

    var adder = 2

    for (k <- 0 until n) {
      intMap.get(k) match {
        case Some(count) if count >= 2 =>

        case Some(count) if count == 1 =>
          if(adder>1){
            adder = 1
          }
        case _ =>
          adder = 0
      }

      mexSum += adder
    }

    println(mexSum)

  }


}