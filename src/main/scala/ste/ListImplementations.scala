package ste

object ListImplementations {
  def last[T](xs: List[T]):T = xs match {
    case List() => throw new Error("Last called on empty list")
    case List(something) => something
    case x :: xs => last(xs)
  }


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
