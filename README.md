# Scala and ScalaTest Examples

Examples from "Scala Cookbook", and just plain Scala examples
that I've seen in various places

# SBT Notes

You might see deprecation warnings from ScalaTest, saying "you can rerun with
-deprecation".  In that case, you can use this in sbt to enable output of
deprecation warnings.

  sbt> set scalacOptions in ThisBuild += "-deprecation"

Subsequently, you can use

  sbt> set scalacOptions in ThisBuild -= "-deprecation"

to remove the option from sbt's running of subsequent tests. See
http://stackoverflow.com/questions/9578521/scala-sbt-how-to-re-run-with-deprecation

## Selectively run tests in sbt

To run the tests in only the "SomeTest" class, use:

  sbt> test-only SomeTest

or

  sbt> ~ test-only SomeTest

## Assert that exceptions are thrown

  test("something") {
    intercept[SomeException] {
      some code here
    }
  }

  There's another way described here:
  http://www.scalatest.org/user_guide/using_assertions

  See ShouldFail.scala

## Mark tests as "pending"

  test("Do something later") (pending)

# Scala Control Structures

The details of How for loops are translated are in the Scala lang.  spec.  Scala
cookbook has a synposis in Chapter 3.1
    
# Finally!  I understand map{ case } vs. map()

VectorTests.scala has an example
# TODO

* TODO How to add -deprecation to the options when running sbt from the
  commandline?

* TODO What does var pizza: Pizza = _ do?
       I suspect that the "_" means something super-special :-/
           
* TODO How to run only certain tests from the commandline?

* TODO How to run certain tests within a class or with "tags" from within sbt?

* TODO How to run only incremental tests (i.e. tests that have changed
       from the last run?

* TODO What is the difference between func(arg1, arg2) and func(arg1)(arg2)

* TODO How to print something from within a scalatest?

* TODO What does the notation "+T1" mean in this definition?
  -- Where can I find a summary of these notations?

```
case class Tuple2[T1, T2](_1: +T1, _2: +T2)
```

* TODO Why does Spark use reduceByKey instead of foldByKey?
  -- For example, if there's only one value for a key, then how does
     it get v2 in the following code?

```
counts = blah.reduceByKey(_+_)
```
