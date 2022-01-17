package com.proj.chapter06

object Scala11_Class1 {

  def main(args: Array[String]): Unit = {
    val user = new User11()
    println(user)
  }
}

class Person11(s: String) {
  println("Person 主构造方法")
  println("Person11 " + s)
}

// 如果父类主构造方法有参数，那么构造对象时必须显示的传递参数
// 可以在继承的父类后面增加小括号，传递参数，等同于调用父类构造方法
class User11(s: String) extends Person11(s) {
  println("User 主构造方法")
  println("User " + s)

  def this() {
    this("123321")
    println("User 辅助构造方法 ")
  }
}