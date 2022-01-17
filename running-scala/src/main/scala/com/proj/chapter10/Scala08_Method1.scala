package com.proj.chapter10

object Scala08_Method1 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)

    // 对集合的数据进行筛选过滤，true保留，false不保留
    val filterList: List[Int] = list.filter(x => x % 2 == 0)
    println(filterList.mkString(","))

    val list1 = List(1, 2, 3, 7)
    val list2 = List(4, 5, 6, 3)
    //    val list3 = List("zs", "l4", "w5")

    // 将两个集合数据进行关联，关联后的数据形成了元组
    val tuples: List[(Int, Int)] = list1.zip(list2)
    println(tuples.mkString(","))

    // 集合并集
    println(list1.union(list2))

    // 集合交集
    println(list1.intersect(list2))

    // 集合差集
    println(list1.diff(list2))
  }

}
