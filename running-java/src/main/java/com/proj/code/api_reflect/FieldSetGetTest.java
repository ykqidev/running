package com.proj.code.api_reflect;

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldSetGetTest {
    @Test
    public void method02() throws Exception {
        Class<?> clazz = Class.forName("com.proj.code.bean.Student");
        Object instance = clazz.newInstance();
        Field field = clazz.getDeclaredField("serialVersionUID");
        field.setAccessible(true);
        System.out.println(field.get(instance));
    }


    @Test
    public void method01() throws Exception {
        Class<?> clazz = Class.forName("com.proj.code.bean.Student");
        Object instance = clazz.newInstance();
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(instance, "李四");
        field.get(instance);
        System.out.println(instance);
    }
}
