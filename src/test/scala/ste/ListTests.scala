package ste
import org.scalatest.FunSuite
class ListTests extends FunSuite {

  val list2 = List(1,2)
  val list3 = list2 :+ 3

  test("Super simple List constructor") {
    val list = 1 :: Nil
    assert(list.isInstanceOf[scala.List[Int]])
  }

  test("List constructor with multiple elements") {
    val list = 2 :: 1 :: Nil
    assert(list.isInstanceOf[scala.List[Int]])
  }

  test("List length, and fancy append") {
    assert(2 === list2.length)
    assert(3 === (list2 :+ 3).length)
  }

  test("list concatenation") {
    assert(list2 ++ List(3) === list3)
  }

  test("list reverse") {
    assert(list2.reverse === List(2, 1))
  }

  test("updated") {
    assert(list2.updated(0, 0) == List(0, 2))
  }

  test("index of") {
    assert(1 === list2.indexOf(2))
  }

  test("contains") {
    assert(list2.contains(2))
    assert(!list2.contains(3))
  }


  test("List init") {
    // Returns all elems except last
    assert(list3.init === list2)
  }
  test("List take") {
    assert(list2.take(1) == List(1))
    assert(list2.take(2) == List(1,2))
    assert(list2.take(3) == List(1,2))
  }

  test("List drop") {
    assert(List(2) === list2.drop(1))
    assert(List() === list2.drop(2))
    assert(List() === list2.drop(3))
  }

  test("List access") {
    assert(list2(0) == 1)
    assert(list2(1) == 2)
  }

  test("List constructor is right-associative") {
    val list = 2 :: 1 :: Nil
    val list2 = Nil.::(1).::(2)

    assert(list.head == 2)          // This looks correct
    assert(list2.head == 2)         // This takes some getting used to
    assert(list === list2)
    assert(list2 === list)

    assert(list.tail.head == 1)
    assert(list2.tail.head == 1)

    assert(list.tail.tail == Nil)
    assert(list2.tail.tail == Nil)
  }


  test("No such element exception thrown") {
    val list = 2 :: 1 :: Nil
    intercept[NoSuchElementException] {
      list.tail.tail.head
    }
  }
}
