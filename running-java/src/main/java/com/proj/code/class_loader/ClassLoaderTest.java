package com.proj.code.class_loader;

import org.junit.Test;

public class ClassLoaderTest {

    static {
        System.out.println("main所在的类的初始化");
    }

    public static void main(String[] args) {
        System.out.println("main方法体打印");
    }

    @Test
    public void method04() throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> c1 = loader.loadClass("java.lang.String");
        System.out.println(c1);
    }


    @Test
    public void method03() throws ClassNotFoundException {
        System.out.println(String[].class);
        System.out.println(int.class);
        System.out.println(int[].class);

//        Class<?> c1 = Class.forName("int"); // 错误的
//        Class<?> c2 = Class.forName("String[]"); // 错误的
        Class<?> c3 = Class.forName("java.lang.String"); // 正确的
        Class<?> c4 = Class.forName("[Ljava.lang.String;"); // 正确的
        Class<?> c5 = Class.forName("[I");  // 正确的
        System.out.println(c3);

    }


    @Test
    public void method02() {
        int num = 10; // 不能用num.getClass()
        Object count = 12;
        System.out.println(count.getClass());
    }

    @Test
    public void method01() {
        System.out.println(Object.class);
        System.out.println(int.class);
        System.out.println(Integer.class);
        System.out.println(void.class);
    }
}
