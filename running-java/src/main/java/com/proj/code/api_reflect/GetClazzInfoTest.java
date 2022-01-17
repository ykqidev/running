package com.proj.code.api_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetClazzInfoTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.proj.code.bean.Student");

        System.out.println(clazz);

        ClassLoader loader = clazz.getClassLoader();
        Package pk = clazz.getPackage();
        System.out.println("包名：" + pk);

        String clazzName = clazz.getName();
        System.out.println("类名：" + clazzName);

        int mod = clazz.getModifiers();
        String modName = Modifier.toString(mod);
        System.out.println("修饰符：" + modName);

        Class<?> superclass = clazz.getSuperclass();
        System.out.println("父类：" + superclass);

        Class<?>[] interfaceList = clazz.getInterfaces();
        for (Class<?> inter : interfaceList) {
            System.out.println("接口：" + inter);
        }

        System.out.println("----------------属性----------------------");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("属性修饰符：" + Modifier.toString(field.getModifiers()));
            System.out.println("属性修饰符：" + field.getType());
            System.out.println("属性名：" + field.getName());
        }

        System.out.println("----------------构造器----------------------");
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("属性修饰符：" + Modifier.toString(constructor.getModifiers()));
            System.out.println("属性名：" + constructor.getName());
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("形参类型：" + parameterType.getName());
            }
        }

        System.out.println("----------------方法----------------------");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("属性修饰符：" + Modifier.toString(method.getModifiers()));
            System.out.println("返回值："+method.getReturnType());
            System.out.println("属性名：" + method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("形参类型：" + parameterType.getName());
            }
        }
    }
}
