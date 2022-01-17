package com.proj.code.collection;

import com.proj.code.bean.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * 对象的比较只有两种方式：(1)==  (2)equals
 * 因为Employee没有重写equals,那么就相当于==
 * <p>
 * 集合中的contains,remove等涉及到对象比较的方法，都是用对象的equals
 */
public class CollectionTest {
    public static void main(String[] args) {

        Collection<Employee> c = new ArrayList<>();
        Employee employee1 = new Employee("张三", 12000);
        Employee employee2 = new Employee("李四", 13000);
        Employee employee3 = new Employee("王五", 15000);
        c.add(employee1);
        c.add(employee2);
        c.add(employee3);

        boolean b = c.contains(new Employee("张三", 12000));
        System.out.println(b);
    }

    //刘一 陈二 张三 李四 王五 赵六 孙七 周八 吴九 郑十
    @Test
    public void listTest() {

        List<String> list = new ArrayList<>();
        list.add("刘一");
        list.add("陈二");
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("孙七");

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Object next = listIterator.next();
            System.out.print(next + " ");
        }

        System.out.println();
        listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            Object prev = listIterator.previous();
            System.out.print(prev + " ");
        }

        System.out.println();
        listIterator = list.listIterator(5);
        while (listIterator.hasPrevious()) {
            Object prev = listIterator.previous();
            System.out.print(prev + " ");
        }
    }
}

