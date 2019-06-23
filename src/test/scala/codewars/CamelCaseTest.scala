package codewars

import org.scalatest.{FlatSpec, Matchers}

class CamelCaseTest extends FlatSpec with Matchers {
  "the_Stealth_Warrior underscore lower start" should "theStealthWarrior" in {
    assert(CamelCase.toCamelCase("the_Stealth_Warrior") === "theStealthWarrior")
  }

  "the-Stealth-Warrior test dash " should "theStealthWarrior" in {
    assert(CamelCase.toCamelCase("the-Stealth-Warrior") === "theStealthWarrior")
  }
}
