package com.proj.chapter06

object Scala17_Interface4 {
  def main(args: Array[String]): Unit = {
//    val mySql = new MySql17()

    // 动态混入，扩展性非常强
    val mySql = new MySql17 with Operate17
    mySql.insert()
  }
}

trait Operate17{
  def insert(): Unit ={
    println("insert data...")
  }
}

//class MySql17 extends Operate17{
class MySql17(){
}