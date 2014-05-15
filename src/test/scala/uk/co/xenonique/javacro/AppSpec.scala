package uk.co.xenonique.javacro;


import org.scalatest.{Matchers, FlatSpec}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AppSpec extends FlatSpec with Matchers {

  "BasicArithmetic" should "perform competent addition" in {
    val a = 1
    val b = 2
    (a + b) should be (3)
  }

}
