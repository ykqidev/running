package com.proj.code.api_reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 在运行期间，动态的创建任意类型的对象，只要这个类型可以创建对象
 */
public class NewInstanceTest {

    @Test
    public void method02() throws Exception{
        Class<?> clazz = Class.forName("com.proj.code.bean.Student");
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        Object instance = constructor.newInstance( "张三");
        System.out.println(instance);
    }

    @Test
    public void method01() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.proj.code.bean.Student");
        try {
            Object instance = clazz.newInstance();
            System.out.println(instance);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
