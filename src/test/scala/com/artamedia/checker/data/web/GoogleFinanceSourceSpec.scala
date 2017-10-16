package com.artamedia.checker.data.web

import com.artamedia.checker.domain._
import org.scalatest.FunSpec
import org.scalatest.Matchers._

class GoogleFinanceSourceSpec extends FunSpec {

  describe("GoogleFinanceSource") {

    it("should return an empty set when the symbol is not found") {

      val badAssets = Set(Symbol("blah"), Symbol("ouch"))
      val res = GoogleFinanceSource.getAssets(badAssets)
      res.size shouldBe 0
    }
  }
}
