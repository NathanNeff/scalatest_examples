package ste

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class PizzaTests extends FunSuite with BeforeAndAfter {

    var pizza: Pizza = _ 

    before {
        pizza = new Pizza
    }

    test("new Pizza has zero toppings") {
        assert(pizza.getToppings.size == 0)
    }

    test("new Pizza has zero toppings, you can do this, too") {
        assertResult(0) {
            pizza.getToppings.size
        }
    }

    test("test pizza pricing") (pending)

    test("Boom should throw an exception") {
        val thrown = intercept[Exception] {
            pizza.boom
        }
        assert (thrown.getMessage === "Boom!")
        // Another way to test an exception
        intercept[Exception] { pizza.boom }
    }
}
