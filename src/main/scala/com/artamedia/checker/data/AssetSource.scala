package com.artamedia.checker.data

import com.artamedia.checker.domain._
import rx.Observable

trait AssetSource {

  def getAssets(assets: Set[Symbol]): Observable[Set[Asset]]
}
