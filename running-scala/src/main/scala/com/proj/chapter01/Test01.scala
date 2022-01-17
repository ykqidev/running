package com.proj.chapter01

import scala.io.StdIn

object Test01 {
  def main(args: Array[String]): Unit = {
    val month: Int = StdIn.readInt()
    println("month：" + month)
    val old: Int = StdIn.readInt()
    println("old：" + old);
    val value: Any = println_sum(month, old)
    println(value)

  }

  def println_sum(month: Int, old: Int): Any = {

    for (i <- 0 to month if (old > i && old % 2 == 0)) {
      println("for循环遍历[0 to month]：" + i)
    }

    if (month <= 11 && month >= 4) {
      if (old < 18) {
        60
      } else if (old > 60) {
        "半价"
      } else {
        1.toDouble / 3.toDouble
      }
    } else {
      if (old > 18) {
        40
      } else {
        20
      }
    }
  }
}
