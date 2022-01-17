package com.proj.code.exception;

import org.junit.Test;

/**
 * 异常的父类：java.lang.Throwable
 * Throwable类是Java语言中所有错误或异常的超类
 *
 * Throwable:
 * (1)Error:是Throwable的子类，用于指示合理的应用程序不应该视图捕获的严重问题。
 *    例如:VirtualMachineError
 * (2)Exception:
 * 又分为两大类：
 * A:RuntimeException运行时异常：只有RuntimeException类型或它的子类是属于运行时异常
 *   凡是运行时异常，编译器不会要求你必须加“try...catch”或“throws”
 *
 *   常见的运行时异常：ArrayIndexOutOfBoundsException
 *                   NullPointerException
 *                   ClassCastException
 *                   ArithmeticException
 *
 * B:编译时异常：除了运行时异常，剩下的全部是编译时异常
 *   凡是编译时异常，编译器强制要求你必须加“try...catch”或“throws”之一，否则编译不通过
 *
 *   常见的编译时异常：InterruptedException:线程中断打扰的异常
 *                   FileNotFoundException:文件找不到
 *                   ...
 *
 * 面试题:
 * 1.编写代码，使得发生VirtualMachineError(OutOfMemoryError,StackOverflowError)
 * StackOverflowError 错误的示例：
 * OutOfMemoryError 错误的示例：
 *
 * 2.列出你开发中常见的异常类型
 * 或
 * 列出几种运行时异常
 * 或
 * 列出几种编译时异常
 */
public class TestExceptionType {

    /**
     * OutOfMemoryError 错误的示例：
     */
    @Test
    public void testOutOfMemoryError(){
        Object[] obj = new Object[Integer.MAX_VALUE];
    }

    /**
     * StackOverflowError 错误的示例
     */
    @Test
    public void testStackOverflowError(){
        testStackOverflowError();
    }



}
