package ste
import org.scalatest.FunSuite
class PairsAndTuplesTests extends FunSuite {
  val emptyList = List[Int]()
  val emptyStringList = List[String]()
  val tup = (1,2)
  val intList = List(1,1)
  test("Pattern matching with Tuple") {
    val (first, second) = tup
    assert(1 === first)
    assert(2 === second)
  }

  test("Reduce Left") {
    assert(2 === intList.reduceLeft(_+_))
  }

  test("reduceLeft throws exception w/empty list") {
      val thrown = intercept[java.lang.UnsupportedOperationException] {
        assert(List(0) === emptyList.reduceLeft(_+_))
      }
      assert (thrown.getMessage === "empty.reduceLeft")
  }

  test("foldLeft works w/empty list") {
      assert(0 === emptyList.foldLeft(0)(_+_))
      assert(1 === emptyList.foldLeft(1)(_+_))
      assert("bork bork" === emptyStringList.foldLeft("bork bork")(_+_))
  }

}
