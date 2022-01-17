package com.proj.code.interview;

import org.junit.Test;

public class IntTest {

    static int x, y, z;

    static {
        x--;
    }

    public static void myMethod() {
        y = z++ + ++z;
    }

    /**
     * 开始执行main方法
     * System.out.println("x=" + x)   // x = -1;
     * z--;                           // z = -1;
     * myMethod();
     * y = z++ + ++z;
     * 指令（1）先把 z "-1" 的值加载到一个操作树栈
     * （2）z 自增 1
     * （3）z 再自增 1
     * （4）再把 z "1"的值加载到一个操作数栈
     * （5）把操作 数栈的值弹出来求和 -1 + 1 = 0
     * （6）把 0 赋值给 y --> y=0,z=1
     * System.out.println("result:"+ (z+y) + ++z));
     * 指令：（1）再把 z "1" 的值加载到一个操作数栈
     * （2）再把 y "0" 的值加栈到一个操作数栈
     * （3）z 先自增
     * （4）再把 z "2"的值加载到一个操作数栈
     * （5）求和 1 + 0 + 2 =3
     * （6）打印
     */
    @Test
    public void method01() {
        System.out.println("x = " + x);
        z--;
        myMethod();
        System.out.println("result:" + (z + y + ++z));
    }
}
