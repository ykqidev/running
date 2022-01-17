package com.proj.chapter10

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Scala03_Seq {

  def main(args: Array[String]): Unit = {
    // 序列 Seq
    val list = List(1, 2, 3, 4)

    // 通过索引获取数据
    //    println(list(0))

    // 增加数据
    val list1 = list :+ 1
//    val list1 = 1 +: list
//    println(list1.mkString(","))
//    println(list == list1) //false
//
//    val list2 = list.++(list1)
////    val list2 = list ++ list1
//    println(list2.mkString(","))
//
//    val list3: List[Int] = list.::(9)
//    println(list3.mkString(","))

    // list中的冒号运算符的运算顺序从右到左
//        val list4: List[Int] = (7 :: (8 :: (9 :: list)))
//    println(list4.mkString(","))
//
//        val list5: List[Any] = 9 :: list1 :: list
//        val list6: List[Any] = 9 :: list1 ::: list
//    //
//        println(list5.mkString(","))
//        println(list6.mkString(","))

    // 特殊List集合：空集合Nil
    //    println(List())
    //    println(Nil)
    //1::2::3::Nil

    //修改
//    val list7: List[Int] = list.updated(2, 5)
////    list7.foreach(print)
//
//    // 删除前两个
//    val list8: List[Int] = list.drop(2)
//    println(list8.mkString(","))
//    for (elem <- list7) {
//      println(elem)
//    }

    // TODO 可变集合
//    val mList = ListBuffer(1, 2, 3, 4)
//
//    // 集合的属性
//    // 头
//    println(mList.head)
//    // 尾（除了头以外）
//    println(mList.tail)
////     最后一个
//    println(mList.last)
//    // 初始（除了最后一个）
//    println(mList.init)

    // 队列(一定可变)
    val queue = mutable.Queue(1, 2, 3, 4)
    println("add before = " + queue)
    queue.enqueue(5)
    println("add after = " + queue)
    val i: Int = queue.dequeue()
    println("i = " + i)
    println("delete after = " + queue)
//    删除头部数据
    queue.dequeue()
    queue.dequeue()
    println("delete after = " + queue)

  }

}
