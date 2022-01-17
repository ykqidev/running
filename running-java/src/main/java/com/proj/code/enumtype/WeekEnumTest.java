package com.proj.code.enumtype;

/**
 * 枚举：列举，罗列
 *
 * 枚举是代表这样的一系列的类型，这些类型有一个非常明显的特征：他们的对象是有限的几个。
 * 例如：Week(星期)，我可以限定Week类型的对象只有个7个：Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
 *      Season(季节)，可以限定对象为4个：Spring，Summer，Autumn,Winter
 *      Status(员工状态)，可以限定为4个：空闲（Free）,忙（Busy）,休假（Vocation）,离职(Left)
 *
 * 枚举类是JDK1.5之后引入的。
 *
 * 枚举类型也是类，原来用class声明，现在用enum来声明枚举
 * 声明的语法格式：
 * 【权限修饰符】 enum 枚举类型名{
 *     常量对象列表；
 *     【其他成员】
 * }
 *
 * 说明：
 * (1)枚举类型的构造器一定是私有的
 * (2)枚举类型的常量对象列表必须在枚举类的首行
 *    如果常量对象列表后面没有其他成员，那么分号“;”可以省略，如果后面还有其他的成员，分号“;”不能省略
 * (3)所有枚举类型有一个直接父类java.lang.Enum类型，所以你不能再继承其他类
 * (4) switch...case
 *
 * 首行：
 *  (1)package
 *  (2)super(),this()
 *  (3)枚举常量对象
 *
 *  switch...case的表达式的类型：
 *  （1）基本数据类型：byte,short,int,char
 *   (2)引用数据类型：枚举，String
 *
 */
public class WeekEnumTest {
    public static void main(String[] args) {
        Week monday = Week.MONDAY;
        Week tuesday = Week.TUESDAY;
        System.out.println(monday);
        System.out.println(tuesday.ordinal());
        System.out.println(monday.getClass());

        switch (monday){
            case MONDAY:
                System.out.println("这是星期一");
                break;
            case SUNDAY:
                System.out.println("这是星期日");
            default:
        }

    }
}


