package com.proj.chapter10

object Scala15_Method5 {
  def main(args: Array[String]): Unit = {

    val list = List(1, List(2, 3), List(4, 5), 6, List(7, 8))
    println(list.flatMap(t => {
      t match {
        case i: List[Int] =>
          println("List=>" + i)
          i
        case _ =>
          println(t)
          List(t)
      }
    }))


    //    只有主线程
//    println((0 to 100).map(_ => Thread.currentThread().getName))
    //    开启线程池，多个子线程
//    println((0 to 100).par.map(_ => Thread.currentThread().getName))

  }


}
