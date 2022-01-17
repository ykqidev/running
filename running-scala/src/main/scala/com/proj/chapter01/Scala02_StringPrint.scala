package com.proj.chapter01

object Scala02_StringPrint {

  def main(args: Array[String]): Unit = {
    val name = "zhangsan"
    val age = 23
    val url = "com.baidu.com"

    printf("name=%s,age=%d,url%s \n", name, age, url)
  }

}
