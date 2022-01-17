package com.proj.chapter10

object Scala11_Method2 {

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)

    // 数据减少，不是结果变少
    // 将集合的数据经过逻辑处理后只保留一个结果，具体的结果需要操控逻辑实现
//    list.reduce((left,right)=>{left+right})
    val result: Int = list.reduce(_ - _)
    println(result)

    // reversed ==> List(4, 3, 2, 1)
    // reduceLeft ==> ((1-2)-3)-4
    // reduceRight ==> 1-(2-(3-4)))
    println(list.reverse)
    println(list.reduceLeft(_ - _))
    println(list.reduceRight(_ - _))
  }

}
