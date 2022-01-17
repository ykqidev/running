package com.proj.code.api_reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 在运行期间，动态的调用任意对象的任意方法
 */
public class MethodInvokeTest {

    @Test
    public void method01() throws Exception {
        Class<?> clazz = Class.forName("com.proj.code.bean.Student");
        Object instance = clazz.newInstance();

        Method method1 = clazz.getDeclaredMethod("setName",String.class);
        Object invoke1 = method1.invoke(instance, "王五");
        System.out.println(invoke1);

        Method method2 = clazz.getDeclaredMethod("getName");
        Object invoke2 = method2.invoke(instance);
        System.out.println(invoke2);


        // 静态方法
        Method method3 = clazz.getDeclaredMethod("getSerialVersionUID");
        Object invoke3 = method3.invoke(null);
        System.out.println(invoke3);
    }

}
