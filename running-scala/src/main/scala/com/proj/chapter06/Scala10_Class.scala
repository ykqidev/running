package com.proj.chapter06

object Scala10_Class {
  def main(args: Array[String]): Unit = {
    val user = new User10;
    user.test1()
    println(user)
  }
}

// 类可以声明为抽象的 abstract
abstract class Person {
  var name: String = _

  // scala中属性也可以重写，因为属性可以抽象
  // 属性只是声明，而没有初始化，那么就是抽象属性
  // 抽象属性在编译为class文件时，不生产属性，但是生产抽象getter方法
  var sex: String

  val email: String = "yyyyy@xx.com"

  // 声明抽象方法，方法只有声明，没有实现，不需要abstract关键字声明
  def test()

  def test1(): Unit = {
    println("father test1...")
  }

}

class User10 extends Person {

  //  如果要重写会报错
  //  override var name: String = "z3"

  // 重写属性，补全属性
  override var sex: String = _

  // 属性可以被覆盖（重写），但是不能重写父类var声明的变量
  override val email: String = "xxxxx@yy.com"

  // 重写抽象方法：补全方法
  def test(): Unit = {
    println("child test...")
  }

  // scala如果子类重写父类的方法（不是抽象），需要增加override关键字
  override def test1(): Unit = {
    println("child test1...")
  }

  override def toString: String = {
    "name：" + name + "，sex：" + sex + "，email：" + email
  }
}
