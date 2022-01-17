package com.proj.chapter06

// 声明类
class User {
  // 类的主体内容 ==> 类体
  // 声明属性
  var username: String = _

  var age: Int = _

  def login(): Boolean = {
    true
  }
}

/**
 * Scala是一个完全面向对象的语言
 */
object Scala01_Object {
  def main(args: Array[String]): Unit = {

    // 创建类的对象
    val user: User = new User()

    // 调用对象的属性和方法
    user.username = "z3"

    println(user.username)
  }
}

