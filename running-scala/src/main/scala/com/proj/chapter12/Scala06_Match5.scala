package com.proj.chapter12

object Scala06_Match5 {
  def main(args: Array[String]): Unit = {
    // 样例类 case class

    // val dollar = new Dollar(1,0)
    // dollar.value = 1
    // val dollar = Dollar(1.0)

    for (amt <- Array(Dollar(1000.0), Currency(1000.0, "RMB"), NoAmount)) {
      val result: String = amt match {
        case Dollar(v) => "$" + v
        case Currency(v, u) => v + " " + u
        case CurrencyXX(v, u) => v + " " + u
        case NoAmount => ""
      }
      println(amt + ": " + result)
    }

    println("===============================================================")
    val dollar: Dollar = Dollar(1.0)
    val dollar2: Dollar = dollar.copy(2.0)
    println(dollar2)
  }

}

abstract sealed class Amount

case class Dollar(value: Double) extends Amount

case class Currency(value: Double, unit: String) extends Amount
case class CurrencyXX(value: Double, unit: String) extends Amount

case object NoAmount extends Amount
