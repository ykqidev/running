package com.proj.chapter10

object Scala12_Method3 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    // 折叠，也可以对集合数据进行简化，获取最终的一条结果
    // fold 方法可以传递2个部分的参数，第一个部分表示集合之外的数据
    // 第二部分的参数表示数据进行的逻辑处理
    println(list.fold(100)(_ - _))
    println(list.foldLeft(100)(_ - _))
    println(list.foldRight(100)(_ - _))
  }
}
