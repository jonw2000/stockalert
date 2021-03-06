package com.artamedia.checker.domain

sealed trait CheckType
case object LowCheck extends CheckType
case object HighCheck extends CheckType

case class Check(assetSymbol: Symbol, price: Price, checkType: CheckType)
