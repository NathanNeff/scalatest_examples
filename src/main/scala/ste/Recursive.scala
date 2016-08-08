package ste
// An attempt at some Recursive stuff
object Recursive {

  def countThese(l: List[Char]): List[(Char, Int)] = {
    List((l.head, 1))
  }

  def insertSorted(x: Char, l: List[Char]): List[Char] = {
    l match {
      case List()  => List(x)
      case y :: ys => if (x <= y) x :: l else y :: insertSorted(x, ys)
    }
  }

}
