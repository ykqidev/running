package com.proj.chapter10

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Scala02_Array {
  def main(args: Array[String]): Unit = {

    // Scala 中的数组，使用Array对象实现，使用中括号声明数组的类型
    // Array[String]
    // Scala可以使用简单地方式创建数组
    // Array可以通过apply方法来创建数组对象
    val ints: Array[Int] = Array(1, 2, 3)
    // 访问数组: 使用小括号，增加索引的方式来访问数组
    //    println(ints(0))

    //    ints.+("adf")
    //    val str = ints + "adf"
    //    println(str)
    //    println(ints.mkString(","))

//        for (elem <- ints if elem!=2) {
//          println(elem)
//        }

    // foreach方法会将数组中的每一个元素进行循环遍历，执行指定函数实现逻辑
//        ints.foreach((i:Int) => {println(i)})
    //    ints.foreach((i) => {println(i)})
//        ints.foreach(println(_))
    //    ints.foreach(println)

    // 增加元素
    // 采用方法向数组中增加新的元素，但是不会对原有数据造成影响，而是产生新的数组
//        val ints1: Array[Int] = ints :+ 5
//        val ints2: Array[Int] = 5 +: ints
    //
//        println(ints1.mkString(","))
//        println(ints2.mkString(","))
    //    println(ints == ints1)

    // 修改数据
//        ints.update(1,8)
//        println(ints.mkString(","))


    // 可变数组
    val arrayBuffer: ArrayBuffer[Int] = ArrayBuffer(5, 6, 7, 8)

    //    println(arrayBuffer(0))
    //
    //    arrayBuffer(0) = 2
    //
    //    println(arrayBuffer.mkString(","))
    //
    //    arrayBuffer.foreach(println)

    // 删除数据
//    val i: Int = arrayBuffer.remove(1)
//    println("i = " + i)
//    arrayBuffer.remove(1, 2)
//    println(arrayBuffer.mkString(","))


    // 可变数组和不可变数组的转换
    val buffer: mutable.Buffer[Int] = ints.toBuffer
    println(buffer.getClass)

    val array: Array[Int] = arrayBuffer.toArray
    println(array.getClass)


  }
}
