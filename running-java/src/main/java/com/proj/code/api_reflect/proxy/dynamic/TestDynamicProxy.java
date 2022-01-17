package com.proj.code.api_reflect.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 动态代理：
 * 代理模式：
 * （1）主题接口
 * （2）被代理类
 * （3）代理类（变化）
 * 1、
 * 不直接写代理类，而是写一个“代理工作处理器”的类
 * 代理工作处理器：这个代理类要替被代理者完成xx事。
 * 这个代理工作处理者必须实现一个接口：java.lang.reflect.InvocationHandler
 * public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {}
 * 这个方法：
 * （1）它不是又程序员手动调用的，这个方法的代码会被编译器自动生成到代理类的对应方法中，当你调用代理类的方法时，自动执行这个方法的代码
 * （2）参数列表
 *      第一个参数：proxy 代理类对象
 *      第二个参数：method 代理类要执行的真正的方法。例如：insert,update...
 *      第三个参数：给method方法的实参列表，如果有的话
 *      返回值：method方法的返回值，就是invoke的返回值，或者说invoke方法的返回值就是作为method方法的返回值
 * （3）编写代码类要替被代理者完成的工作
 * 例如：给所有方法都增加一个功能，统计该方法的运行时间。
 *
 * 2、动态的生成代理类及其它的对象
 * 这个时候就需要借助java.lang.reflect.Proxy
 *     Proxy 提供用于创建动态代理类和实例的静态方法。
 * static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
 * 第一个参数：传入被代理者的类加载器
 * 第二个参数：传入被代理者实现的接口们
 * 第三个参数：传入代理者要替被代理者完成的工作的处理器对象。
 * 不同的类加载器加载的class，JVM认为是不同的类型。
 */
public class TestDynamicProxy {

    public static void main(String[] args) {

        // 创建被代理者的对象
        UserDao userDao = new UserDaoImpl();
        Class<?> clazz = userDao.getClass();
        // 获取被代理者的类加载器对象
        ClassLoader loader = clazz.getClassLoader();
         // 获取被代理者实现的接口
        Class<?>[] clazzInterfaces = clazz.getInterfaces();
        // 创建代理者要替被代理者完成的工作的处理器对象
        Handler handler = new Handler(userDao);

        // 动态的创建代理类和它的对象
        // 得到的就是代理类的对象，代理类在内存中自动生成
        UserDao instance = (UserDao) Proxy.newProxyInstance(loader, clazzInterfaces, handler);
        instance.insert();

        instance.delete();

    }
}

