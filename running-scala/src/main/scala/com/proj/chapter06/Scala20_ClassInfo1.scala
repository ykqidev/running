package com.proj.chapter06

// Scala会自动导入Scala包中的类
object Scala20_ClassInfo1 extends App {
  println("ColorEnum is " + ColorEnum.RED)
}

// 枚举
object ColorEnum extends Enumeration {
  // 隐式转换
  var RED: ColorEnum.Value = Value(1, "red")
  var Yellow: ColorEnum.Value = Value(2, "yellow")
}