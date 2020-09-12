package round670


object B extends App {

  val t = scala.io.StdIn.readInt()

  for (_ <- (0 until t)) {
    val n = scala.io.StdIn.readInt()
    val arr = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

    val res = arr.sorted.slice(n - 5, arr.length).foldRight(1, (a: Int, b: Int) => a * b)


    println(res)

  }


}