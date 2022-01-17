package com.proj.code.api_reflect.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class Handler implements InvocationHandler {
    private Object target;

    public Handler(Object target) {
        this.target = target;
    }

    /**
     * 这个方法：
     * （1）它不是又程序员手动调用的，这个方法的代码会被编译器自动生成到代理类的对应方法中，当你调用代理类的方法时，自动执行这个方法的代码
     * （2）参数列表
     *      第一个参数：proxy 代理类对象
     *      第二个参数：method 代理类要执行的真正的方法。例如：insert,update...
     *      第三个参数：给method方法的实参列表，如果有的话
     *      返回值：method方法的返回值，就是invoke的返回值，或者说invoke方法的返回值就是作为method方法的返回值
     * （3）编写代码类要替被代理者完成的工作
     * 例如：给所有方法都增加一个功能，统计该方法的运行时间。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("开始执行" + method.getName() + "时间");
        System.out.println("代理类型："+proxy.getClass().getName());


        Object invoke = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("结束执行" + method.getName() + "时间");
        System.out.println("耗时：" + (end - start));
        return invoke;
    }
}
