package com.artamedia.checker.testutil

import com.artamedia.checker.domain.{Asset, Check, CheckType, HighCheck, LowCheck, Price, Symbol}
import org.scalacheck.{Arbitrary, Gen}

object CheckerGenerators {

  implicit val checkTypeGen: Arbitrary[CheckType] = Arbitrary(Gen.oneOf(LowCheck, HighCheck))

  implicit val symbolGen = Arbitrary(Gen.resultOf(Symbol))

  implicit val priceGen = Arbitrary(Gen.resultOf(Price))

  implicit val assetGen = Arbitrary(Gen.resultOf(Asset))

  implicit val checkGen = Arbitrary(Gen.resultOf(Check))
}
