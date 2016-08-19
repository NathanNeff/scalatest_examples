package ste

import org.scalatest._
class ListImplementationsTests extends FunSuite {
  val li = ListImplementations
  val empty = List()
  val one = List(1)
  val two = List(1,2)
  test("Empty List") {
    val thrown = intercept[Error] {
      li.last(empty)
    }
    assert(thrown.getMessage == "Last called on empty list")
  }

  test("List w/one item") {
    assert(li.last(one) === 1)
  }

  test("List w/more than one item") {
    assert(li.last(two) === 2)
  }
}



