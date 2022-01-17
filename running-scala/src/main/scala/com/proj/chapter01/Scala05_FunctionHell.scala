package com.proj.chapter01

object Scala05_FunctionHell {

  def main(args: Array[String]): Unit = {

    def f1(i: Int) = {
      def f2(j: Int): Unit = {
        println(i * j)
      }
      //表示将f2方法转换为函数
      //在方法名称f2后面紧跟一个空格 和下划线 告诉编译器将方法转换成函数,而不是调用这个方法,也可以显示的告诉编译器需要改将这个方法转换成函数
      f2 _
    }

    f1(3)(5)
    //    return


    def f3(i: Int)(j: Int): Int = {
      i * j
    }

    println(f3(4)(5))


    def f4(f: (Int, Int) => Unit): Unit = {
      f(10, 10)
    }

    def f5(i: Int, j: Int): Unit = {
      println(i + j);
    }

    def f6(): Unit = {
      f5(5, 6)
    }

    f6()
    f4(f5)

    def f8(f: (Int) => String): String = {
      f(10) + "方法嵌套";
    }

    def f9(num: Int): String = {
      num + "10"
    }

    //    println(s" = ${f8(() => {"......"})}")
    println(f8(f9))
  }

}
