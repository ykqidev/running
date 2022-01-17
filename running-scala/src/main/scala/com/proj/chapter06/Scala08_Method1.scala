package com.proj.chapter06

import scala.util.Random

object Scala08_Method1 {
  def main(args: Array[String]): Unit = {
    // 采用伴生对象来创建伴生类
    var student1: Student = Student("lisi")
    student1.age = 12
    val student2: Student = Student.apply("zhangsasn")
    student2.age = 13
    println(student1)
    println(student2)

    val random = new Random();
    for (_ <- Range(1,5)){
      println(random.nextInt(10))
    }
  }
}
