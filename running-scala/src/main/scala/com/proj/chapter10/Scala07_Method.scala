package com.proj.chapter10

/**
 * 集合常用的方法
 */
object Scala07_Method {

  def main(args: Array[String]): Unit = {

    // 集合常用的方法
    val list = List(1, 2, 3, 4,3)

//    // 求和
//    println("sum = " + list.sum)
//    // 最大值
//    println("max = " + list.max)
//    // 最小值
//    println("min = " + list.min)
//    // 乘积
//    println("product = " + list.product)
//    // 反转（无排序）
//    println("reverse = " + list.reverse)

//    // 分组（通过指定函数的返回值进行分组）
//    val groupList: Map[Int, List[Int]] = list.groupBy(x => x%2)
//    groupList.foreach(t=>{println(t._1 + "=" + t._2)})

    val stringsList = List("13", "12", "22", "23")
//    val groupStringList: Map[String, List[String]] = stringsList.groupBy(s => {
//      s.substring(0, 1)
//    })
//    println(groupStringList)

    // 排序（按照指定的规则进行排序）
//    val ints: List[Int] = list.sortBy(x => x)
//    println(ints)
//    println(stringsList.sortBy(x => {
//      x.substring(1)
//    }))
////     升序 小 => 大
//    println(list.sortWith((x, y) => {
//      x < y
//    }))
////     升序 大 => 小
//    println(list.sortWith((x, y) => {
//      x > y
//    }))
//
//    println(stringsList.sortWith((left, right) => {
//      left.substring(1) > right.substring(1)
//    }))
//    // 迭代
//    for (elem <- list.iterator) {
//      println(elem)
//    }
//    // 映射（转换）
////     x = >(x,x)
//    val intToInt: Map[Int, Int] = list.map(x => {
//      (x, 1)
//    }).groupBy(x => x._1).mapValues(x => x.size)
//    println(intToInt)

//    val listSize: Map[Int, Int] = list.groupBy(x=>x).mapValues(x=>x.size)
//    println(listSize)

    // TODO WordCount
    // 对集合中的单词字符串进行统计出现的次数，并且按照出现次数降序排序，取前3名
    val wordList = List("Hello", "Scala", "Hello", "Hbase", "World", "Hadoop", "Kafka", "Scala", "World")
    println(wordList.groupBy(x => x).map(x => {
      (x._1, x._2.size)
    }).toList.sortWith(_._2 > _._2).take(3).toMap)

    // TODO 扁平化操作
    // 将一个整体中的内容拆成一个一个的个体
    val lineList = List("Hello World", "Hello Scala", "Hello Hadoop")

    println(lineList.flatMap(x => {
      x.split(" ")
    }).map(x=>(x,1)).groupBy(x=>x._1).mapValues(x=>x.size).toList.sortBy(x=>x._2))
  }
}
