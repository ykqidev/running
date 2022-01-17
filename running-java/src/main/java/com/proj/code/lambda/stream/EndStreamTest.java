package com.proj.code.lambda.stream;

import com.proj.code.bean.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EndStreamTest {

    @Test
    public void test3() {
        ArrayList<Employee> arr = new ArrayList<>();
        arr.add(new Employee(2,"王五",22));
        arr.add(new Employee(1,"刘一",23));
        arr.add(new Employee(3,"陈二",18));
        List<Employee> employeeList = arr.stream()
                .filter(e -> e.getAge() > 20)
                .collect(Collectors.toList());
        employeeList.forEach(System.out::println);
    }

    @Test
    public void test2() {
        boolean stream = Stream.of(2, 3, 5, 6, 89, 9).anyMatch(p -> p % 2 == 0);
        System.out.println(stream);
    }

    @Test
    public void test1() {
        Optional<Integer> stream = Stream.of(2, 3, 5, 6, 89, 9).max(Comparator.comparingInt(o -> o));
        System.out.println(stream);
    }
}
