package contest1469

object C extends App {

  val t = scala.io.StdIn.readInt()

  for (_ <- 0 until t) {
    val nk = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList
    val n = nk.head
    val k = nk(1)
    val h = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

    if (check(n, k, h)) println("YES") else println("NO")
  }


  def check(n: Int, k: Int, h: List[Int]): Boolean = {

    def findInternalExtremums(list: List[(Int, Int)]): List[El] = list.zipWithIndex.sliding(3).foldLeft(List.empty[El]) {
      case (acc, List(((prev, _), _), ((cur, repeats), jj), ((next, _), _))) =>
        if ((cur > prev && cur > next) || (cur < prev && cur < next))
          El(cur, repeats, jj) :: acc
        else
          acc
      case (acc, _) => acc
    }

    case class El(h: Int, repeats: Int, i: Int)

    def createListWithRepeats(list: List[Int]): List[(Int, Int)] = {
      list.foldLeft(List.empty[(Int, Int)]) {
        (acc, a) =>
          acc match {
            case h :: tail if h._1 == a => (h._1, h._2 + 1) :: tail
            case _ => (a, 1) :: acc
          }
      }.reverse
    }

    val listWithRepeats: List[(Int, Int)] = createListWithRepeats(h)

    (h, listWithRepeats) match {
      case (list, listWR) if list.length == n && listWR.length >= 2 =>

        val extremums: List[El] = (El(listWR.head._1, listWR.head._2, 0) :: findInternalExtremums(listWR) ++ List(El(listWR.last._1, listWR.last._2, listWR.length - 1))).sortBy(_.i)


        extremums.sliding(2).toList.forall {
          case List(El(e1, r1, i), El(e2, r2, j)) =>
            val length = Math.abs(j - i)
            (length +(r1-1)+(r2-1)) * (k - 1) >= Math.abs(e1 - e2)

          case _ => false
        }


      case _ => false
    }

  }

}
