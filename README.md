# ScalaTest Examples

From "Scala Cookbook"

# SBT Notes

You might see deprecation warnings from ScalaTest, saying "you can rerun with
-deprecation".  In that case, you can use this in sbt to enable output of
deprecation warnings.

  set scalacOptions in ThisBuild += "-deprecation"

Subsequently, you can use

  set scalacOptions in ThisBuild -= "-deprecation"

to remove the option from sbt's running of subsequent tests. See
http://stackoverflow.com/questions/9578521/scala-sbt-how-to-re-run-with-deprecation


# TODO

* TODO How to add -deprecation to the options when running sbt from the
  commandline?

* TODO What does var pizza: Pizza = _ do?
       I suspect that the "_" means something super-special :-/
           
* TODO How to run only certain tests from the commandline?

* TODO How to run certain tests from within sbt?

* TODO How to run only incremental tests (i.e. tests that have changed
       from the last run?
