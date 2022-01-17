package com.proj.chapter06

object Scala12_Class2 {
  def main(args: Array[String]): Unit = {
    val user = new User12("321");
    println(user.name)
  }
}

// 类构造方法的参数作用域默认为整个类的主体，但是如果想要参数作为属性来使用，可以采用特殊方式声明：var
class User12(var name:String){
  // var name : String = s
}