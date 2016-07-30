package ste

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

class PizzaSpec extends FunSpec with BeforeAndAfter {
    var pizza: Pizza = _ 

    before {
        pizza = new Pizza
    }

    describe("A new Pizza") {

        it("should start with no toppings") {
            assert(pizza.getToppings.size === 0)
        }

        it("should allow addition of toppings") (pending)
        it("should allow removal of toppings") (pending)
    }

}
