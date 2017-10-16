package com.artamedia.checker.data.web

import com.artamedia.checker.data.AssetSource
import com.artamedia.checker.domain.{PricedAsset, Symbol}

object GoogleFinanceSource extends AssetSource {

  override def getAssets(assets: Set[Symbol]): Set[PricedAsset] = {

    Set()
  }
}
