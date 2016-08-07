package ste
import org.scalatest.FunSuite
class ListTests extends FunSuite {

  test("Super simple List constructor") {
    val list = 1 :: Nil
    assert(list.isInstanceOf[scala.List[Int]])
  }

  test("List constructor with multiple elements") {
    val list = 2 :: 1 :: Nil
    assert(list.isInstanceOf[scala.List[Int]])
  }

  test("List constructor is right-associative") {
    val list = 2 :: 1 :: Nil
    val list2 = Nil.::(1).::(2)

    assert(list.head == 2)          // This looks correct
    assert(list2.head == 2)         // This takes some getting used to

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
