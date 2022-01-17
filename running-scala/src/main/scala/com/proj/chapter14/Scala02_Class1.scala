package com.proj.chapter14

object Scala02_Class1 {
  def main(args: Array[String]): Unit = {
    // 默认情况下，scala中的泛型和java一样，不变
    // 在scala中，为了丰富泛型的功能，提供了协变，逆变的类型操作
    val obj: Test[User1] = new Test[Child1]
    println(obj)

    val list = List(1, 2, 3, 4)
//    list.reduceLeft[User1]()
  }
}

class Person1{}

class User1 extends Person1{}

class Child1 extends User1{}

class Test[+User1]{}