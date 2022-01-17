package com.proj.chapter13

object Scala01_Function {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, "abc")
    val list1 = list.map(x => {
      if (x.isInstanceOf[Int]) {
        x.asInstanceOf[Int] + 1
      }
    })

    println(list1.filter(x => true))
    println(list1.filter(x => x.isInstanceOf[Int]))

    println("=====================================================================")
    def f1(n: Any): Boolean = {
      n.isInstanceOf[Int]
    }

    def f2(n: Int): Int = {
      n + 1
    }

    def f3(n: Any): Int = {
      n.asInstanceOf[Int]
    }

    val list2 = list.filter(f1).map(f3).map(f2)
    println("list2= " + list2)

    println("=====================================================================")
    val list3 = List(1, 2, 3)
    val addOne3 = new PartialFunction[Any, Int] {
      override def isDefinedAt(x: Any): Boolean = {
        if (x.isInstanceOf[Int]) true
        else false
      }

//      如果入参为其他类型可能会报错
      override def apply(v1: Any): Int = v1.asInstanceOf[Int] + 1
    }

    // 收集，collect方法支持偏函数，收集满足条件的数据
    println(list3.collect(addOne3))
    // map 方法不能执行偏函数操作，因为必须对所有的数据进行转换，不能只对其中一部分进行操作
    println(list3.map(addOne3))

    println("=====================================================================")
    val list4 = list.collect {
      case i: Int => i + 1
    }

    println("list4= " + list4)

    val stringList: List[String] = list.map(num => num + "xxx")

    println(stringList)

    println(list.sortWith {
      case (left, right) =>
        left.toString > right.toString
    })
  }
}
