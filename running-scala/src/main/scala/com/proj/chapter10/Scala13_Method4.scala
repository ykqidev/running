package com.proj.chapter10

import scala.collection.mutable

object Scala13_Method4 {

  def main(args: Array[String]): Unit = {
    // 将两个Map进行合并，相同的key做累加，不同的key直接增加
    // a->4,b->2,c->5,d->1

    // map.get(key) == null,v
    // map.get(key) !=null map.get(key) + v
    val map1 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map2 = mutable.Map("a" -> 3, "b" -> 2, "d" -> 1)

    println(map1.foldLeft(map2)((map2, t) => {
      //      println(map1(t._1))
      //      println(t._1 + "=>" + t._2)
      //      println(t)
      map2(t._1) = map2.getOrElse(t._1, 0) + t._2
      println(map2(t._1))
      map2
    }))


    //    用来解析上面的foldLeft
    val lst = List(20, 30, 60)
    //0为初始值，b表示返回结果对象（迭代值），a表示lst集合中的每个值
    lst.foldLeft(0)((b, a) => {
      println(b + a)
      b + a
    })
  }
}
