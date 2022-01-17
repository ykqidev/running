package com.proj.chapter06

// 类的方法
// 所谓的方法，其实就是类中声明的函数，所以声明方式和函数式是一样，调用方式上有区别
object Scala07_Method {
  def main(args: Array[String]): Unit = {
    val user = new User07
    println(user.login())
    println(user.logout())
  }

}

class User07 {
  def login(): Unit = {
    println("login...")

  }

  def logout(): Boolean = {
    println("logout...")
    true
  }
}