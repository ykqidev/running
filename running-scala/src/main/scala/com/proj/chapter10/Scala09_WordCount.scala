package com.proj.chapter10

object Scala09_WordCount {
  def main(args: Array[String]): Unit = {
    val tuples = List(("Hello Scala World", 4), ("Hello World", 3), ("Hello Hadoop", 2), ("Hello Hbase", 1))

    println(tuples.flatMap(x => {
      x._1.split(" ").map(i => (i, x._2))
    }).groupBy(x => x._1).mapValues(x => x.map(x => x._2).sum).toList.sortWith(_._2 > _._2))


    val tuples2 = List(1, List(2, 3), 4, List(5, 6))
    println(tuples2.flatMap(x => {
      x match {
        case list: List[Int] =>
          println(list)
          list
        case _ =>
          List(x)
      }
    }))
  }
}
