package com.artamedia.checker.data

import com.artamedia.checker.domain._

trait AssetSource {

  def getAssets(assets: Set[Symbol]): Set[PricedAsset]
}
