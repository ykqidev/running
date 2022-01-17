package com.proj.chapter10

import org.junit.Test

import scala.io.{BufferedSource, Source}

object Scala10_WordCountFile {

  def main(args: Array[String]): Unit = {
    val source: BufferedSource = Source.fromFile("practice_scala/file/input/word.txt")
    println(source.getLines().toList)
  }

}
