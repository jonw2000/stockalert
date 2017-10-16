package com.artamedia.checker.domain

case class Symbol(name: String) extends AnyVal

trait Asset {
  val symbol: Symbol
}

case class PricedAsset(symbol: Symbol, price: Price) extends Asset
