package com.artamedia.checker.domain

case class Email(recipients: Set[String], subject: String, body: String)
