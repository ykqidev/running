package com.proj.chapter09

object Scala02_Transform1 {

  def main(args: Array[String]): Unit = {
    implicit def transform(mysql: Mysql): Operator = {
      new Operator
    }

    val mysql = new Mysql
    mysql.select()
    mysql.delete()
  }
}

class Operator {
  def delete(): Unit = {
    println("delete....")
  }
}

class Mysql {
  def select(): Unit = {
    println("select....")
  }
}