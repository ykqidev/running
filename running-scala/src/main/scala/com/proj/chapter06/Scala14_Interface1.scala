package com.proj.chapter06

object Scala14_Interface1 {

  def main(args: Array[String]): Unit = {
    // java中的接口无法直接构建对象，必须使用实现类
    // java中的接口是可以声明方法的，早期版本中声明的方法都是抽象，新版本的是可以有默认实现
    // java中的接口是可以声明属性的，属性值无法修改

    // scala中的特质也无法构建对象
    // scala中的特质是可以执行代码
    // scala特质中声明的属性和方法都可以在混入的
//     new TestTrait14()

    val user = new User14
    user.test()
  }
}

trait TestTrait14{
  println("get into TestTrait14")
  var username : String = "z3"
  def test(): Unit ={
    println("trait's test...")
  }
  // 特质中也可以声明抽象方法
//  def test()
}

class Person14 {

}

class User14 extends Person14 with TestTrait14{
  override def test(): Unit = {
    println("user's test...")
  }
}
