package com.proj.code.lambda.stream;

import com.proj.code.bean.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class MiddleStreamTest {
    @Test
    public void method06() {
        Stream.of("hello,world,java","123,456,789")
                .flatMap(t -> Stream.of(t.split(",")))
                .forEach(System.out::println);
    }

    @Test
    public void method05() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).map(t -> t * 10).forEach(System.out::println);
    }


    @Test
    public void method04() {
        Stream.of(16, 2, 56, 1, 3, 6, 9, 8, 7).sorted(Comparator.comparingInt(o -> -o)).forEach(System.out::println);
    }


    @Test
    public void method03() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).peek(System.out::println).count();
    }


    @Test
    public void method02() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(2, "张三", 23));
        list.add(new Employee(2, "张三", 23));

        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void method01() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(2, "张三", 23));
        list.add(new Employee(2, "张三", 23));

        list.stream().filter(t -> !"张三".equals(t.getName())).forEach(System.out::println);
    }

}
