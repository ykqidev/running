package com.proj.chapter06

/**
 * 接口
 * scala中没有接口（interface）的概念，有特质（trait）的概念，类似于接口
 */
object Scala13_Interface {

}

// 声明特质
trait TestTrait1{

}

trait TestTrait2{

}

class Person13{

}

// 特质可以继承的，所以使用extends关键字
// 如果类继承多个特质，采用with连接
// 如果类同时存在父类和特质，依然采用继承方式，但是继承的是父类，连接特质
class User13 extends TestTrait1 with TestTrait2{

}