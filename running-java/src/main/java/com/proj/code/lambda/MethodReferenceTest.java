package com.proj.code.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 方法引用和构造器引用，是对Lambda表达式的再次简化的一个语法。
 * 当Lambda表达式的Lambda体满足一些情况时，可以使用方法引用或构造器引用再次简化：
 * （1）当Lambda体是通过调用一个先有的类、对象的先有的方法来完成功能时，
 * （2）并且这个方法的形参列表和返回值类型，与该Lambda表达式所赋值的函数式接口的抽象方法的形参列表和返回值类型对应。
 * <p>
 * 语法格式：
 * 类名或对象名::方法名/new
 * 形式：
 * （1）对象::实例方法名
 * （2）类名::静态方法名
 * （3）类名::实例方法名
 * （4）类名::new --> 构造器引用
 * （5）数组类型::new --> 特殊的构造器引用，数组的构造器引用
 */
public class MethodReferenceTest {

    /**
     * 自定义方法：功能：可以创建一个数组对象，但是要求这个数组的长度必须是2的n次方
     * 如果不是，会往上转为最近的2的n次方
     */
    public <R> R[] createArray(Function<Integer,R[]> fun,int length){
        int n = length - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        length = n < 0 ? 1 : n + 1;
        return fun.apply(length);
    }
    /**
     * Function<T,R>：功能型接口 抽象方法，有参有返回值 R apply(T t)
     *
     * Function<Integer,R[]>：T是Integer类型，R是R[]数组类型
     */
    @Test
    public void test5(){
//        createArray((length) -> new String[length],11);

        String[] array = createArray(String[]::new, 11);
        System.out.println(array.length);
    }


    public <T> T method(Supplier<T> s) {
        return s.get();
    }

    /**
     * 类名::new --> 构造器引用
     */
    @Test
    public void test4() {
        /*
         * Supplier<T> 是供给型接口，T get()
         *
         * Lambda体是通过 new 一个对象来完成的
         */
//        method(() -> new String());
        // 可以用构造器引用
        method(String::new);
    }

    /**
     * 类名::实例方法名
     */
    @Test
    public void test3() {
        TreeSet<String> set = new TreeSet<>(String::compareToIgnoreCase);
        set.add("Yfd");
        set.add("fa");
        set.add("teh");
        set.forEach(System.out::println);
    }

    /**
     * 类名::静态方法名
     */
    @Test
    public void test2() {
        /*
         * java.util.stream包下Stream类
         *      static <T> Stream<T> generate(Supplier<T> s)
         *
         * 函数式接口：Supplier<T> 供给型接口，抽象方法 T get() 无参有返回值
         *
         * 现在 lambda体 我通过调用Math.random()来完成
         * 因为 lambda体 通过调用Math类的先有的方法来完成的，并且形参列表和返回值类型对应，都是无参，有返回值
         */
        Stream<Double> stream = Stream.generate(Math::random);
//        stream = stream.limit(30);
        stream.forEach(System.out::println);

    }


    /**
     * 对象::实例方法名
     */
    @Test
    public void test1() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("张三");
        arr.add("王五");
        arr.add("李四");
        arr.forEach(System.out::println);
    }
}

