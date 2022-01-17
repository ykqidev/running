package com.proj.code.lambda.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 1、创建Stream
 * （1）用数组创建
 * 数组工具类：java.util.Arrays
 *     static <T> Stream<T> stream(T[] array)
 * （2）用集合创建
 *      集合对象.stream()
 * （3）用Stream中的of方法
 *      Stream.of(T... values)
 * （4）无限流
 *      Stream类中
 *      static <T> Stream<T> generate(Supplier<T> s)
 *      static <T> Stream<T> iterate(T seed,UnaryOperator<T> f)
 *      UnaryOperetor<T>：是一个函数式接口，extends Function<T,T>
 *           T apply(T t)
 */
public class CreateStreamTest {

    @Test
    public void test5() {
        /*
         * t 是流中的数据，第一个数据是1，种子
         * 在1的基础上+2，并且不断地迭代
         * 数据流中的数据 1,3,5,7,9...
         */
        Stream<Integer> stream = Stream.iterate(1, t -> t + 2);
        stream.forEach(System.out::println);
    }

    @Test
    public void test4() {
        Stream<Double> stream = Stream.generate(Math::random);
        stream.forEach(System.out::println);
    }


    @Test
    public void test3() {
        Stream<String> stream = Stream.of("java", "hello", "world");
        stream.forEach(System.out::println);
    }

    @Test
    public void test2() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("张三");
        arr.add("李四");
        Stream<String> stream = arr.stream();
        stream.forEach(System.out::println);
    }

    @Test
    public void test1() {
        String[] arr = {"hello", "world", "java"};
        Arrays.stream(arr).forEach(System.out::println);
    }

}
