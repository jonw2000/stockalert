package com.artamedia.checker.data

import com.artamedia.checker.domain._
import com.artamedia.checker.util.DateProvider

trait AssetSource {

  def getAssets(assets: Set[Symbol])(implicit dateProvider: DateProvider): Set[PricedAsset]
}
