package com.artamedia.checker

import com.artamedia.checker.domain._
import com.artamedia.checker.testutil.CheckerGenerators._
import org.scalatest.FunSpec
import org.scalatest.Matchers._
import rx.Observable

class AssetCheckerSpec extends FunSpec {
  describe("An AssetChecker") {

    it("should result in no alerts when there are no assets or checks") {
      val sut = new AssetChecker

      sut.runChecks(Observable.empty(), Observable.empty())
          .toBlocking.first().size should ===(0)

      val asset = assetGen.arbitrary.sample.head
      sut.runChecks(Observable.just(Set[Asset](asset)), Observable.empty())
        .toBlocking.first().size should ===(0)

      val check = checkGen.arbitrary.sample.head
      sut.runChecks(Observable.empty(), Observable.just(Set[Check](check)))
        .toBlocking.first().size should ===(0)
    }

    it("should result in no alerts when low check fails") {
      val sut = new AssetChecker

      val asset = Asset(Symbol("IBM"), Price(100))
      val check = Check(asset, Price(110), LowCheck)

      sut.runChecks(Observable.just(Set(asset)), Observable.just(Set(check)))
        .toBlocking.first().size should ===(0)
    }

    it("should result in no alerts when high check fails") {
      val sut = new AssetChecker

      val asset = Asset(Symbol("IBM"), Price(110))
      val check = Check(asset, Price(100), HighCheck)

      sut.runChecks(Observable.just(Set(asset)), Observable.just(Set(check)))
        .toBlocking.first().size should ===(0)
    }

    it("should result in one alert when high check succeeds") {
      val sut = new AssetChecker

      val asset = Asset(Symbol("IBM"), Price(110))
      val check = Check(asset, Price(120), HighCheck)

      sut.runChecks(Observable.just(Set(asset)), Observable.just(Set(check)))
        .toBlocking.first().size should ===(1)
    }
  }
}
