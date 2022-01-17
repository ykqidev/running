package com.proj.chapter06

object Scala18_Interface5 {
  def main(args: Array[String]): Unit = {
    val mysql = new MySql18()
    mysql.insert()
//    mysql.getMessage()
  }
}

// 特质继承类
//trait Operate18 extends Exception{
trait Operate18 {
  // 特质使用的范围
  this: Exception =>
  def insert(): Unit = {
    println("insert data...")
    this.getMessage
  }
}

class MySql18 extends Exception with Operate18 {

}