package ste

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class PizzaTests extends FunSuite with BeforeAndAfter {
// TODO What does this do?
    var pizza: Pizza = _ 

    before {
        pizza = new Pizza
    }

    test("new Pizza has zero toppings") {
        assert(pizza.getToppings.size == 0)
    }

    test("test pizza pricing") (pending)
}
