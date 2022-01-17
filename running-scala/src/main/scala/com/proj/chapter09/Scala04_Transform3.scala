package com.proj.chapter09

object Scala04_Transform3 {
  def main(args: Array[String]): Unit = {
    val user4 = new User4()
    user4.insert()
    user4.delete()
  }
}

class User4 extends Test{
  def insert(): Unit ={
    println("insert...")
  }
}

trait Test{

}

object Test{
  implicit class Person4(u:User4){
    def delete(): Unit ={
      println("delete...")
    }
  }
}