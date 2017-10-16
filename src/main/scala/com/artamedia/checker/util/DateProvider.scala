package com.artamedia.checker.util

import java.time.LocalDate

trait DateProvider {

  def now: LocalDate
}
