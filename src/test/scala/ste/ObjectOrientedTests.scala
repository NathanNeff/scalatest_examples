package ste

import org.scalatest._
import scala.reflect.runtime.universe.{TypeTag, typeOf}

class ObjectOrientedTests extends FunSuite with Matchers {

  test("Class relationship") {
    val foo = List[Any]("Something")
    val bar = 1 :: foo
    println(typeOf[Any])
  }

  test("something") {
    1 shouldBe a [java.lang.Integer]
    val foo = "St"
    foo shouldBe a [Any]
    List(1,2) shouldBe a [Seq[_]]
    List(1,2) shouldBe a [List[_]]
    val blerk = intercept[Exception] {
      List(1,2) shouldBe a [Vector[_]]
    }
  }

}
