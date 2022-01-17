package com.proj.chapter12

object Scala04_Match3 {
  def main(args: Array[String]): Unit = {
    for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0), Array(1, 1, 0), Array(1, 1, 0, 1))) {
      val result = arr match {
        case Array(0) => "0"
        case Array(x, y) => x + "-" + y
        case Array(0, _*) => "以0开头和数组"
        case _ => "什么集合都不是"
      }
      println("result=" + result)
    }

    println("========================================================================")
    for (list <- Array(List(0), List(5, 0), List(0, 0, 0), List(1, 0, 0))) {
      val result = list match {
        case 0 :: Nil => "0"
        case x :: y :: Nil => x + " " + y
        case 0 :: tail => "0 ..."
        case _ => "something else"
      }
      println(result)
    }

    println("========================================================================")
    // 元组匹配
    for (pair <- Array((0, 1), (1, 0), (2, 1), (1, 0, 2))) {
      val result = pair match {
        case (0, _) => "0 ..."
        case (y, 0) => y
        case (a, b) => (b, a)
        case _ => "other"
      }
      println(result)
    }

    println("========================================================================")
    // 对象匹配
    object Square {
      def unapply(arg: Double): Option[Double] = Some(math.sqrt(arg))

      def apply(z: Double): Double = z * z
    }

    //    val result = Square(6)

    // 模式匹配使用：
    val number: Double = 36.0
    number match {
      case Square(n) => println(n)
      case _ => println("nothing matched")
    }
  }

}
