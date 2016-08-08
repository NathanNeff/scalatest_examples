package ste

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class RecursiveTests extends FunSuite {

  test("Test simple count these") {
    val ret = Recursive.countThese(List('a'))
    assert(ret.head == ('a', 1))

    val ret2 = Recursive.countThese(List('b'))
    assert(ret2.head == ('b', 1))
  }

  test("Even simpler insert into list") {
    val result = Recursive.insertSorted('a', List('b'))
    assert(result.head === 'a')
    assert(result.tail.head === 'b')
    assert(result.tail.tail.isEmpty)
  }


}
