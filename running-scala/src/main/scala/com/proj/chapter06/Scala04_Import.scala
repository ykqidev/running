package com.proj.chapter06

/**
 * import 用于导入类
 * import 可以在任意的地方使用
 * import 可以导入一个包中所有的类，采用下划线代替星号
 * import java.util._
 *
 * import 导入相同包中的多个类，采用大括号进行包含处理
 * import java.util.{ArrayList,List,Date}
 *
 * import 可以采用特殊的方式来隐藏指定的类：{类名=>_}
 * import java.util.{Date=>_}
 * import java.sql.Date
 *
 * scala可以在导入类的时候给类起别名
 * import java.util.{HashMap=>JavaHashMap}
 *
 */
object Scala04_Import {
  def main(args: Array[String]): Unit = {
//    new util.Date()
    // new JavaHashMap()
  }
}

// scala中如果想要从最开始的包中查找类，需要增加绝对路径，使用_root_开头

import _root_.java.util._

//package java{
//  package util{
//    class HashMap{
//    }
//  }
//}

object Scala05_Import1 {
  def main(args: Array[String]): Unit = {
    var map = new _root_.java.util.HashMap()
    println(map)
  }
}
