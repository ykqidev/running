package com.proj.chapter06

object Scala19_ClassInfo {
  def main(args: Array[String]): Unit = {
    // 如果想要获取类的信息，需要采用特殊的方法
    // classOf能直接使用，因为scala.Predef伴生对象是默认导入到当前开发环境中
    val userClass: Class[User19] = classOf[User19]
    println("getInterfaces：" + userClass.getInterfaces)
    println("getClasses：" + userClass.getClasses)

    type UserType = User19
    val userType = new UserType()
    println("userType is " + userType)
    println("========================================================================\n")
    var user: Object = new User19
    // 判断类型
    val bool: Boolean = user.isInstanceOf[User19]
    println("user is User type：" + bool)
    if (bool) {
      // 转换类型
      user = user.asInstanceOf[User19]
      println("user's object is " + user)
    }
  }
}

class User19 {
}
