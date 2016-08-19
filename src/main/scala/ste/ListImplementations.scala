package ste

object ListImplementations {
  def last[T](xs: List[T]):T = xs match {
    case List() => throw new Error("Last called on empty list")
    case List(something) => something
    case x :: xs => last(xs)
  }
}
