package com.proj.chapter10

import java.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConversions.asScalaBuffer


object Scala14_ScalaToJava {

  def main(args: Array[String]): Unit = {
    val arr: ArrayBuffer[String] = ArrayBuffer("1", "2", "3")
    println(arr)

    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(arr)
    val arrList: util.List[String] = javaArr.command()
    println(arrList)


    val scalaArr : mutable.Buffer[String] = arrList

    scalaArr.append("jack")
    println(scalaArr)
  }


}
