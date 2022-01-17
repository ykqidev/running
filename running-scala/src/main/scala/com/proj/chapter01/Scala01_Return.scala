package com.proj.chapter01

object Scala01_Return {
  def main(args: Array[String]): Unit = {
    val value = test(true)
    println(value)

  }

  def test(flag: Boolean): Any = {

    val str: String = if (flag) "aaa" else "bbb"
    println(str)
  }

}
