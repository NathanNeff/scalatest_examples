package ste
import org.scalatest.FunSuite
class ControlStructuresTests extends FunSuite {
    /* The details of How for loops are translated
     * are in the Scala lang. spec.  Scala cookbook has
     * a synposis in Chapter 3.1
     */

    test("For test with \"big\" numbers") {
        val data = Array.range(0, 5 * 1000 * 1000)
        for (item <- data) {
            assert(item === data(item))
        }
    }

    test("For with index") {
        val data = Array.range(0, 5 * 1000 * 1000)
        for (item <- 0 until data.length) {
            assert(item === data(item))
        }
    }

}
