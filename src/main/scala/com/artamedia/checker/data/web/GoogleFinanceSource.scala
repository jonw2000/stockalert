package com.artamedia.checker.data.web

import com.artamedia.checker.data.AssetSource
import com.artamedia.checker.domain.{PricedAsset, Symbol}
import com.artamedia.checker.util.DateProvider
import com.artamedia.finscrapes.{GoogleScraper, WebProvider}

class GoogleFinanceSource(webProvider: WebProvider) extends AssetSource {

  override def getAssets(assets: Set[Symbol])(implicit dateProvider: DateProvider): Set[PricedAsset] = {

    assets.flatMap(asset => {
      val scraper = GoogleScraper(asset.name, dateProvider.now, dateProvider.now, webProvider)
      val ticks = scraper.get
      ticks.headOption
    })
    Set()
  }
}
