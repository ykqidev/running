package com.proj.chapter12

object Scala05_Match4 {
  def main(args: Array[String]): Unit = {

    // 特殊的模式匹配
    val (x, y) = (1, 2)
    val (username, age, email) = ("z3", 18, "xxx@.com")
    println(username + "=" + age)

    println("=================================================")
    // 包含了2个连续的运算符
    val (q, r) = BigInt(10) /% 3
    println("q =" + q)
    println("r =" + r)

    println("=================================================")
    val list = List(("a", 1), ("b", 2), ("c", 3))

    for ((k, v) <- list) {
      println(k + "=" + v)
    }
  }
}
