package com.artamedia.checker.data.web

import java.time.LocalDate

import com.artamedia.checker.domain._
import com.artamedia.checker.util.DateProvider
import com.artamedia.finscrapes.WebProvider
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FunSpec, Matchers}

class GoogleFinanceSourceSpec extends FunSpec with Matchers with MockitoSugar {

  val mockProvider: WebProvider = (url: String) => {
    println(url)
    ""
  }

  describe("GoogleFinanceSource") {

    implicit val dateProvider = new DateProvider{
      override def now = LocalDate.parse("2017-01-01")
    }
    val googleFinanceSource = new GoogleFinanceSource(mockProvider)

    it("should return an empty set when no assets are sent") {

      val badAssets: Set[Symbol] = Set()
      val res = googleFinanceSource.getAssets(badAssets)
      res.size shouldBe 0
    }

    it("should return an empty set when the symbol is not found") {

//      when(mockProvider.get(anyString())).thenReturn("")

      val badAssets = Set(Symbol("blah"), Symbol("ouch"))
      val res = googleFinanceSource.getAssets(badAssets)
      res.size shouldBe 0
    }

    it("should return the correct asset and price when the symbol is found") {

//      when(mockProvider.get(anyString())).thenReturn("")

      val ibm = Set(Symbol("IBM"))
      val res = googleFinanceSource.getAssets(ibm)
      res.size shouldBe 1
    }
  }
}
