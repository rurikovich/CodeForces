package round670

object AFunctional extends App {

  val t = scala.io.StdIn.readInt()

  for (_ <- (0 until t)) {
    val n = scala.io.StdIn.readInt()

    val arrStr = scala.io.StdIn.readLine()
    val stdInArr: Array[Int] = arrStr.split(" ").map(_.toInt)

    println(mex(stdInArr))

  }


  def mex(stdInArr: Array[Int]): Int = {
    val n = stdInArr.length

    val intMap = stdInArr.foldLeft(Map.empty[Int, Int]) {
      (map: Map[Int, Int], b: Int) => {
        map - b + (b -> (map.getOrElse(b, 0) + 1))
      }
    }

    val startAdder = 2
    (0 until n).foldLeft((0, startAdder)) {
      (mexSum_adder: (Int, Int), k: Int) => {
        val mexSum = mexSum_adder._1
        val adder = mexSum_adder._2

        val newAdder = intMap.get(k) match {
          case Some(count) if count >= 2 =>
            adder
          case Some(count) if count == 1 =>
            if (adder > 1) {
              1
            } else adder
          case _ => 0
        }

        (mexSum + newAdder, newAdder)

      }
    }
  }._1


}