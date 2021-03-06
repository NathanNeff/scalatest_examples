package ste

import org.scalatest._

class ListImplementationsTests extends FunSuite {
  val li = ListImplementations
  val empty = List()
  val one = List(1)
  val oned = List(1.0)
  val two = List(1,2)
  val three = List(1,2,3)
  val fruits = List("strawberry", "peach", "apple")

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

  test("concat function on list") {
    assert(List() === li.concat(List(), List()))
    assert(one === li.concat(List(), one))
    assert(one === li.concat(one, List()))
    assert(three === li.concat(List(1), List(2,3)))
  }

  test("reverse") {
    assert(li.reverse(two) === List(2,1))
    assert(li.reverse(three) === List(3, 2,1))
  }

  test("removeAt") {
    assert(li.removeAt(two, 1) === one)
  }

  test("Test MergeSort") {
    assert(li.mergeSort(List(2,1,1)) === List(1, 1, 2))
    assert(li.mergeSort(two) === two)
    assert(li.mergeSort(List(2,1,3)) === List(1, 2, 3))
    assert(li.mergeSort(List(1)) === List(1))
    assert(li.mergeSort(List()) === List())
  }
  // Uses a function provided, in order to sort things
  test("Test MergeSort2") {
    def sortAsc(x:Int, y:Int):Boolean = x < y
    def sortDesc(x:Int, y:Int):Boolean = x > y

    assert(li.mergeSort2(List(2,1,1), sortAsc) === List(1, 1, 2))
    assert(li.mergeSort2(List(2,1,1), sortDesc) === List(2, 1, 1))

    assert(li.mergeSort2(two, sortAsc) === two)
    assert(li.mergeSort2(List(2,1,3), sortAsc) === List(1, 2, 3))

    assert(li.mergeSort2(List(1), sortAsc) === List(1))
    assert(li.mergeSort2(List(1), sortDesc) === List(1))

    assert(li.mergeSort2(List(), sortAsc) === List())
    assert(li.mergeSort2(List(), sortDesc) === List())

    assert(li.mergeSort2(fruits, (x:String, y:String) => x.compareTo(y) < 0) 
      === List("apple", "peach", "strawberry"))
  }

  test("Test MergeSort3") {
    def sortAsc(x:Int, y:Int):Boolean = x < y
    def sortDesc(x:Int, y:Int):Boolean = x > y

    assert(li.mergeSort3(List(2,1,1))(Ordering[Int]) === List(1, 1, 2))

    // Implicits help condense based on demanded type
    assert(li.mergeSort3(two) === two)
    assert(li.mergeSort3(two)(Ordering.Int) === two)

    assert(li.mergeSort3(List(2,1,3))(Ordering.Int) === List(1, 2, 3))

    assert(li.mergeSort3(List(1))(Ordering.Int) === List(1))
    assert(li.mergeSort3(List(1))(Ordering.Int) === List(1))

    assert(li.mergeSort3(List()) === List())
    assert(li.mergeSort3(List()) === List())

    assert(li.mergeSort3(fruits)(Ordering.String) === List("apple", "peach", "strawberry"))
    assert(li.mergeSort3(fruits) === List("apple", "peach", "strawberry"))
  }

  test("Scale List function") {
    assert(List(2.0) == li.scaleList(oned, 2.0))
  }

  test("Map function") {
    assert(li.map(List())(x => x * 2) === List())
    assert(li.map(one)(x => x * 2) == List(2))
    assert(li.map(two)(x => x * x) == List(1, 4))
  }

  test("Filter function") {
    assert(li.filter(List(1,2,3))(x => x == 1) == List(1))
    assert(li.filter(List(1,2,3))(x => x == 2) == List(2))
    assert(li.filter(List(1,2,3))(x => x >= 2) == List(2, 3))
  }
}



