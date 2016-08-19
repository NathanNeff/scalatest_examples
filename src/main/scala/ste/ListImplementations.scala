package ste

object ListImplementations {
  // Return a list containing everything /except/ the last
  // item
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("Init called on empty list")
    case List(x) => List()
    case x :: xs  => x :: init(xs)
  }


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

  // Must be careful here, because it needs to be right-associative?
  // Complexity of concat will be a call for each element of X |xs| = mathematical notation
  // to indicate size
  def concat[T](xs:List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }

  // Append operator ++ used.  Can we do better than this w/regard to
  // complexity?
  def reverse[T](xs:List[T]): List[T] = xs match {
    case List() => xs
    case z :: zs => reverse(zs) ++ List(z)
  }

  def removeAt[T](xs:List[T], index: Int): List[T] = (xs take index) ::: (xs drop index + 1)

  def mergeSort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = 
        xs match {
          case Nil => ys
          case x1 :: xs1 => 
            ys match {
              case Nil => xs
              case y1 :: ys1 =>
                if (x1 < y1) x1 :: merge(xs1, ys)
                else y1 :: merge(xs, ys1)
            }
        }
      val (fst, snd) = xs splitAt n
      merge(mergeSort(fst), mergeSort(snd))
    }
  }

  // TODO: Parameterize mergeSort in ListImplementations to use
  // a providable "merge" function (See README.md)
  def mergeSort2[T](xs: List[T], lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x1 :: xs1, y1 :: ys1) =>
                if (lt(x1, y1)) x1 :: merge(xs1, ys)
                else y1 :: merge(xs, ys1)
        }
      val (fst, snd) = xs splitAt n
      merge(mergeSort2(fst, lt), mergeSort2(snd, lt))
    }
  }
  // mergeSort3 uses the Ordering object, (and uses separate
  // function passed as param to allow currying
  // Cool! implicit!
  def mergeSort3[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x1 :: xs1, y1 :: ys1) =>
          if (ord.lt(x1, y1)) x1 :: merge(xs1, ys)
          else y1 :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      merge(mergeSort3(fst)(ord), mergeSort3(snd)(ord))
    }
  }

}
