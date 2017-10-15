package com.artamedia.checker

import com.artamedia.checker.domain.{Alert, Asset, Check}
import rx.Observable

trait Checker {
  def runChecks(assets: Observable[Set[Asset]], checks: Observable[Set[Check]]): Observable[Set[Alert]]
}

class AssetChecker extends Checker {
  override def runChecks(assets: Observable[Set[Asset]], checks: Observable[Set[Check]]): Observable[Set[Alert]] = {
    Observable.just(Set[Alert]())
  }
}

