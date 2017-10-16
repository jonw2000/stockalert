package com.artamedia.checker.testutil

import com.artamedia.checker.domain.{Check, CheckType, HighCheck, LowCheck, Price, PricedAsset, Symbol}
import org.scalacheck.{Arbitrary, Gen}

object CheckerGenerators {

  implicit val checkTypeGen: Arbitrary[CheckType] = Arbitrary(Gen.oneOf(LowCheck, HighCheck))

  implicit val symbolGen = Arbitrary(Gen.resultOf(Symbol))

  implicit val priceGen = Arbitrary(Gen.resultOf(Price))

  implicit val pricedAssetGen = Arbitrary(Gen.resultOf(PricedAsset))

  implicit val checkGen = Arbitrary(Gen.resultOf(Check))
}
