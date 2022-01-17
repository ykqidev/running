package com.proj.chapter10

import scala.collection.mutable

object Scala04_Set {
  def main(args: Array[String]): Unit = {
    // Set集合：无序，不可重复
    // 默认scala提供的set集合就是不可变的（immutale）
    val set: Set[Int] = Set(1, 2, 5, 3)
    // 增加数据
    // println(set + 11)
    // 删除数据
    println( set - 5)
    for (elem <- set) {
      println(elem)
    }

    // 可变Set集合（mutable）
    val mSet = mutable.Set(1, 2, 3, 4)

  }
}
