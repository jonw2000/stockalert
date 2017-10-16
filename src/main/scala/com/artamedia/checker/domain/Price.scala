package com.artamedia.checker.domain

case class Price(pence: Int) extends AnyVal

object PriceIsFractional extends Fractional[Price] {

  // Ordering:
  def compare(x: Price, y: Price): Int = x.pence compare y.pence

  // Numeric:
  def plus (x: Price,y: Price): Price = Price(x.pence + y.pence)
  def minus(x: Price,y: Price): Price = Price(x.pence - y.pence)
  def times(x: Price,y: Price): Price = Price(x.pence * y.pence)
  def negate(x: Price): Price = Price(-x.pence)
  def fromInt (x: Int): Price = Price(x)
  def fromDouble (x: Double): Price = Price(x.toInt)
  def toInt   (x: Price): Int    = x.pence
  def toLong  (x: Price): Long   = x.pence.toLong
  def toFloat (x: Price): Float  = x.pence.toFloat
  def toDouble(x: Price): Double = x.pence.toDouble

  // Fractional:
  def div(x: Price,y: Price): Price = Price(x.pence / y.pence)
}
