package com.proj.code.exception;

/**
 * throws与方法重写
 *
 * 方法的重写（Override）的要求：
 * (1)方法名：必须相同
 * (2)形参列表：必须相同
 * (3)返回值类型：
 *      基本数据类型和void：必须相同
 *      引用数据类型：<=
 * (4)权限修饰符：>=
 * (5)抛出的异常列表的类型：<=
 *
 * 两同两小一大
 *
 */
public class ThrowsTest {
    public static void main(String[] args) {
        Father f = new Son();
        try {
            Object o = f.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Father{

    protected Object test() throws Exception{
        System.out.println("父类的");
        return null;
    }
}

class Son extends Father{
    @Override
    public String test() throws RuntimeException {
        System.out.println("子类的");
        return "";
    }
}