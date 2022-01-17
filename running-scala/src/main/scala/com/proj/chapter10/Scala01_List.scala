package com.proj.chapter10

object Scala01_List {
  def main(args: Array[String]): Unit = {
    // Java中的集合：List，Set，Map（可变）
    // List : 有序，可重复
    // LinkedList，ArrayList
    // Set : 无序，不可重复
    // HashSet，TreeSet
    // Map ：无序，（K-V）key不能重复，value可重复
    // HashMap，Hashtable,TreeMap

    // 数组（不可变）
    // int[] ints = new int[4]

    // Scala中集合，主要分为两大类：可变（mutable）& 不可变（immutable）

    val ints = List(1, 2, 3, 4)
    println(ints.mkString("+"))
  }
}
