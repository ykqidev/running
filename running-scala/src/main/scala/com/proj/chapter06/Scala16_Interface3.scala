package com.proj.chapter06

object Scala16_Interface3 {
  def main(args: Array[String]): Unit = {
    val sql = new MySql
    sql.insert()
  }
}

trait Operate{
  def insert(): Unit ={
    println("insert data...")
  }
}

// 特质可以继承其他的特质
// 特质重写父特质的方法
trait DB extends Operate{
  println("get into DBTrait....")

  override def insert(): Unit = {
    print("operation database => ")
    super.insert()
  }
}

trait File extends Operate{
  println("get into FileTrait....")

  override def insert(): Unit = {
    print("operation file => ")
    super.insert()
//    super[Operate].insert()
  }
}

// 多特质混入时，代码执行顺序为从左到右，如果有父特质，会优先执行
// 多特质混入时，方法调用的顺序为从右到左
// 特质中super关键字不是指向父特质，指代的是上一级特质
// 如果希望super指向父特质，需要增加特殊操作 : super[特质]
// java的接口可以在scala中当成特质来用
class MySql extends File with DB with Serializable {

}


