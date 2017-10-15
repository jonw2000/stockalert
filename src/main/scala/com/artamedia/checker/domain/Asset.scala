package com.artamedia.checker.domain

case class Symbol(name: String) extends AnyVal
case class Price(pence: Int) extends AnyVal

case class Asset(symbol: Symbol, price: Price)
