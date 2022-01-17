package com.proj.code.lambda.express;

/**
 * 1    拷贝小括号， 写死右箭头， 落地大括号
 * 2    @FunctionalInterface
 * 3    default
 * 4    static
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        Foo foo = () -> System.out.println("add");
        System.out.println(foo.ff(1,2));
    }
}


