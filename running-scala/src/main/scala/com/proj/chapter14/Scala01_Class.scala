package com.proj.chapter14

object Scala01_Class {
  def main(args: Array[String]): Unit = {
    test(new Child)
  }

  // <: 表示泛型的下限，所以传递数据时，应该为子类或当前类
  def test[T <: User](t: T): Unit = {
    println(t)
  }
}


class Person {
}

class User extends Person {
}

class Child extends User {
}