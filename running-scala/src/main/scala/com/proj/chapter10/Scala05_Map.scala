package com.proj.chapter10

import scala.collection.mutable

object Scala05_Map {
  def main(args: Array[String]): Unit = {

    // Map集合：K-V对
    // hashMap.put("k","v)
    // Scala中k-v对数据采用特殊的方式声明
    // 默认Map集合不可变
    val map: Map[String, Int] = Map("a" -> 1, "b" -> 2, "c" -> 3)
    println(map.mkString(","))
    val map1: Map[String, Int] = map + ("d" -> 4)
    println(map1.mkString(","))
    //    println(map == map1)
    // 删除数据 返回值为一个新的map
    val map2: Map[String, Int] = map - ("a")
    println(map2.mkString(","))

    // 修改数据
    val map3: Map[String, Int] = map.updated("b", 5)
    println(map3.mkString(","))

    // 循环遍历
    // Scala为了防止集合出现空指针问题，提供了一个特殊的类，Option,有两个特殊的对象：Some,None
    // 如果确实没有获取到数据，为了不出现异常，Option类提供了有默认值的方法
//    println(map.get("f").get)  // 如果获取不到会抛出异常NoSuchElementException
//    println(map.get("f").getOrElse(0))
    println(map.getOrElse("f",0))
    // 可变Map集合
     val mutableMap: mutable.Map[String, Int] = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    println(mutableMap.mkString(","))


  }

}
