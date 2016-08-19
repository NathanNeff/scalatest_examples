package ste

import org.scalatest._
class ListImplementationsTests extends FunSuite {
  val li = ListImplementations
  val empty = List()
  val one = List(1)
  val two = List(1,2)
  val three = List(1,2,3)

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
    assert(2 === li.last(two))
    assert(3 === li.last(three))
  }


  ignore("Test simple count these") {
    val ret = li.countThese(List('a'))
    assert(ret.head == ('a', 1))

    val ret2 = li.countThese(List('b', 'a', 'a'))
    assert(ret2.head == ('b', 1))
    assert(ret2.tail.head == ('a', 2))
  }

  test("Even simpler insert into list") {
    val result = li.insertSorted('b', List('a','c'))
    assert(result.head === 'a')
    assert(result.tail.head === 'b')
    assert(result.tail.tail.head === 'c')
  }


  test("init function") {
    intercept[Error] {
      assert(List() == li.init(List()))
    }
    assert(List() == li.init(one))
    assert(one == li.init(two))
    assert(two == li.init(three))
  }

  ignore("concat function on list") {
    // assert(List(1,1,2) == li.concat(list1, list2))
    // assert(List(1,2,1,2,3) == li.concat(list2, list3))
    // assert(List(1,2) == li.concat(List(), list2))
    // assert(list2 == li.concat(list2, List()))
  }
  
}



