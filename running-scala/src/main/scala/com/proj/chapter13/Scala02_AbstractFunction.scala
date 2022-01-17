package com.proj.chapter13

import scala.util.control.Breaks

object Scala02_AbstractFunction {
  def main(args: Array[String]): Unit = {
//    Breaks.breakable {
//      for () {
//        Breaks.break()
//      }
//    }

    // 函数作为参数传递给另外一个函数，如果这个函数不需要参数，也不需要返回值，那么可以直传递代码逻辑
    // 声明方式： => Unit
//    def test(b: Boolean)(f: => Unit): Unit = {
//      f
//    }
//
//    test(true) {
//      println("xxxxx")
//    }

    // 控制抽象 进阶用法 实现类型while的until函数
    var x = 10

    def until(condition: => Boolean)(block: => Unit): Unit = {
      if (condition) {
        block
        until(condition)(block)
      }
    }

    until(x > 0) {
      x -= 1
      println("x=" + x)
    }
  }
}
