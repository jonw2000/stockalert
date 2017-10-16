package com.artamedia.checker.data

import com.artamedia.checker.domain.Check

trait CheckSource {

  def getChecks(): Set[Check]
}
