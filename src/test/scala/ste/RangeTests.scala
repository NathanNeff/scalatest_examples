package ste

import org.scalatest.FunSuite

/* 
 * Ranges are represented by a start, stop and a step
 */

class RangeTests extends FunSuite {
  test("Range") {
    assert((1 until 5) === List(1,2,3,4))
    assert((1 to 5) === List(1,2,3,4,5))
    assert((1 until 5).isInstanceOf[scala.collection.immutable.Range])
  }

}
