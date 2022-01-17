package com.proj.bigdata.scala.chapter06

import com.proj.bigdata.scala.chapter06.p1.p2.UserP2
import com.proj.bigdata.scala.chapter06.p1.p3.UserP3

import scala.beans.BeanProperty

// 类的属性
object scala06_Field {

  def main(args: Array[String]): Unit = {
//    var user = new User06
    var user = new UserP2
//
//    var user = new UserP3
//    user.test()

    // getter
    println(user.username)
    // setter
    user.username = "z3"
    println(user)
  }
}

// Scala中也有四种访问权限
// 1) public 2)protected 3)default(package) 4)private
// public 是默认的访问权限，没有关键字
// protected 访问权限只能子类访问，同包访问不了
// private 私有访问权限，只能当前类访问
// 包访问权限需要采用特殊的语法规则：private[包名]
package p1 {
  package p2 {

    class UserP2 {
      var username = "zhangsan"
      private var password = "123321"
      protected var email = "ads@xx.com"
      private[p2] var address = "xxxxx"

      override def toString: String = {
        "username:" + username + ",password:" + password + ",email:" + email + ",address:" + address
      }
    }
  }

  package p3 {

    import com.proj.bigdata.scala.chapter06.p1.p2.UserP2

    class UserP3 extends UserP2 {
      def test(): Unit = {
        val user = new UserP2
        println(user)
      }
    }
  }
}

class User06 {

  // 声明属性
  // scala 中给类声明属性，默认为私有的，但是底层提供了公共的setter和getter方法
  var username: String = _

  // 如果给属性增加private修饰符，那么属性无法在外部访问，因为底层生产的setter和getter方法都是私有的
  // 但半生对象可以访问
  private var age: Int = _

  // 如果声明的属性使用val，那么属性是私有的，并且使用final修饰，底层只提供getter方法，而没有setter方法
  val email: String = ""

  // 为了和java bean规范统一，scala提供了注解，生产java中对应的set,get方法
  @BeanProperty var address: String = _

  override def toString: String = {
    "username:" + username + ",age:" + age + ",email:" + email + ",address:" + address
  }
}