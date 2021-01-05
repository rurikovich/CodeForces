package contest1469

object B extends App {

  val t = scala.io.StdIn.readInt()

  for (_ <- 0 until t) {
    val n = scala.io.StdIn.readInt()
    val r = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

    val m = scala.io.StdIn.readInt()
    val b =  scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

    println(f(r,b))
  }


  def f(r: List[Int], b: List[Int]): Int = maxSum(r) + maxSum(b)

  def maxSum(r: List[Int]): Int = {
    r.foldLeft((0, 0)) {
      case ((maxSum, sum), a) =>
        val s = sum + a
        (math.max(maxSum, s), s)
    }._1

  }
}
