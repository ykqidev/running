package com.proj.chapter09

object Scala03_Transform2 {
  def main(args: Array[String]): Unit = {

    // 隐式值
    implicit val username: String = "w5"
//    implicit val age : Int = 10
    // implicit val username123 : String = "w5"

    // 隐式参数
    def test(implicit name: String = "z3"): Unit = {
//    def test(name: String = "zhangsan"): Unit = {
      println("Hello " + name)
    }

    def test1(implicit name: String): Unit = {
      println("Hello " + name)
    }

//     test("q7")
     test() // 方法调用时，使用小括号会导致隐式值无法传递
//    test1 //方法调用时，不使用小括号可以传递隐式值

    // 如果隐式参数存在默认值以及对应类型的隐式值，那么会优先采用隐式值，如果找不到，那么会使用默认值，
    // 如果没有默认值，那么会发生错误
  }
}
