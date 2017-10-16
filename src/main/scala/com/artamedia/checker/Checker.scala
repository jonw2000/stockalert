package com.artamedia.checker

import com.artamedia.checker.domain._

trait Checker {
  def runChecks(assets: Set[PricedAsset], checks: Set[Check]): Set[Alert]
}

object AssetChecker extends Checker {
  override def runChecks(assets: Set[PricedAsset], checks: Set[Check]): Set[Alert] = {

    val assetMap = assets.map(asset => (asset.symbol, asset)).toMap

    def check(chk: Check): Option[Alert] = {
      assetMap.get(chk.assetSymbol).fold(None: Option[Alert]){
        activeAsset =>
          chk.checkType match {
            case LowCheck if activeAsset.price.pence < chk.price.pence => Some(Alert(activeAsset, ""))
            case HighCheck if activeAsset.price.pence > chk.price.pence => Some(Alert(activeAsset, ""))
            case _ => None
          }
      }
    }
    checks.foldLeft(Set[Alert]())((acc, chk) => check(chk).fold(acc)(acc + _))
  }
}

