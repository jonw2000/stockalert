package com.artamedia.checker

import com.artamedia.checker.domain._
import com.artamedia.checker.testutil.CheckerGenerators._
import org.scalatest.FunSpec
import org.scalatest.Matchers._

class AssetCheckerSpec extends FunSpec {
  describe("An AssetChecker") {

    it("should result in no alerts when there are no assets or checks") {
      val sut = AssetChecker

      sut.runChecks(Set.empty, Set.empty).size should ===(0)

      val asset = pricedAssetGen.arbitrary.sample.head
      sut.runChecks(Set(asset), Set.empty).size should ===(0)

      val check = checkGen.arbitrary.sample.head
      sut.runChecks(Set.empty, Set(check)).size should ===(0)
    }

    it("should result in no alerts when low check fails") {
      val sut = AssetChecker

      val asset = PricedAsset(Symbol("IBM"), Price(110))
      val check = Check(asset.symbol, Price(100), LowCheck)

      sut.runChecks(Set(asset), Set(check)).size should ===(0)
    }

    it("should result in no alerts when high check fails") {
      val sut = AssetChecker

      val asset = PricedAsset(Symbol("IBM"), Price(100))
      val check = Check(asset.symbol, Price(110), HighCheck)

      sut.runChecks(Set(asset), Set(check)).size should ===(0)
    }

    it("should result in one alert when high check succeeds") {
      val sut = AssetChecker

      val asset = PricedAsset(Symbol("IBM"), Price(110))
      val check = Check(asset.symbol, Price(100), HighCheck)

      sut.runChecks(Set(asset), Set(check)).size should ===(1)
    }

    it("should result in one alert when low check succeeds") {
      val sut = AssetChecker

      val asset = PricedAsset(Symbol("IBM"), Price(100))
      val check = Check(asset.symbol, Price(110), LowCheck)

      sut.runChecks(Set(asset), Set(check)).size should ===(1)
    }

    it("should result in two alerts when low check succeeds") {
      val sut = AssetChecker

      val ibm = PricedAsset(Symbol("IBM"), Price(100))
      val google = PricedAsset(Symbol("GOG"), Price(1000))
      val ibmCheck = Check(ibm.symbol, Price(110), LowCheck)
      val googleCheck = Check(google.symbol, Price(1100), LowCheck)

      sut.runChecks(Set(ibm, google), Set(ibmCheck, googleCheck)).size should ===(2)
    }
  }
}
