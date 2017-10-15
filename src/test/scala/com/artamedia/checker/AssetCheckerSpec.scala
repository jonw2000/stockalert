package com.artamedia.checker

import com.artamedia.checker.domain.{Asset, Check}
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

  }
}
