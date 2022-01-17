package com.proj.chapter12

object Scala01_Match {

  def main(args: Array[String]): Unit = {

    // 下划线
    // 模式匹配的其他场合，系统给变量赋初始值，类似于java导包的星号，给类起别名，隐藏类，
    // 代替方法的参数，可以让函数不执行

    val oper = '-'
    val n1 = 20
    val n2 = 10
    var res = 0
    oper match {
      case '+' => res = n1 + n2
      case '-' => res = n1 - n2
      case '*' => res = n1 * n2
      case '/' => res = n1 / n2
      case _ => println("oper error")
    }

    println("res=" + res)
  }
}
