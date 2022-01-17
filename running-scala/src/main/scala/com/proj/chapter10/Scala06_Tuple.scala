package com.proj.chapter10

object Scala06_Tuple {
  def main(args: Array[String]): Unit = {
    // Tuple : 元组
    // Map( k -> v)
    // 将无关的数据当成一个整体来使用
    // empid,email,ordernum
    // 使用小括号将数据关联在一起，形成一个整体
    // 元组中最多的元素数据的个数为22
    val tuple: (String, Int, String) = ("z3", 111111, "xxxx")
    // 访问元组中的数据，调用相应的顺序编号：_顺序号
    //    println(tuple._1)
    //    println(tuple._2)
    //    println(tuple._3)

    //循环遍历
    for (elem <- tuple.productIterator) {
      println(elem)
    }

    // 如果元组中元素的个数为2，那么称之为对偶，类似于Map中键值对
    val tuple1: (Int, String) = (1, "z3")
    val tupleMap: Map[Int, String] = Map((1, "z3"))
    tupleMap.foreach(t => {
      println(t._1 + "=" + t._2)
    })
  }
}

class User {
  var username: String = _
  var age: Int = _
}