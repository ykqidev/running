package com.proj.code.lambda;

import com.proj.code.bean.Book;
import com.proj.code.bean.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

public class LambdaTest {

    @Test
    public void method04() {
        BookService bookService = new BookService();
        ArrayList<Book> books = bookService.query(p -> p.getId() == 2);
        books.forEach(System.out::println);

        ArrayList<Book> bookArrayList = bookService.query(p -> p.getPrice() > 50);
        bookArrayList.forEach(System.out::println);
    }

    @Test
    public void method03() {
        TreeSet<Student> set = new TreeSet<>((o1, o2) -> o1.getScore() == o2.getScore() ? o1.getId() - o2.getId() : o1.getScore() - o2.getScore());
        set.add(new Student(3, "r张三", 69));
        set.add(new Student(1, "E陈二", 87));
        set.add(new Student(5, "e刘一", 87));
        set.add(new Student(4, "s李四", 87));
        set.add(new Student(2, "T王五", 76));

        set.forEach(System.out::println);

    }

    @Test
    public void method02() {
        TreeSet<Student> set = new TreeSet<>((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        set.add(new Student(3, "r张三", 69));
        set.add(new Student(1, "E陈二", 56));
        set.add(new Student(4, "e刘一", 96));
        set.add(new Student(5, "s李四", 87));
        set.add(new Student(2, "T王五", 76));

        set.forEach(System.out::println);

    }


    @Test
    public void method01() {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student(3, "r张三", 69));
        arr.add(new Student(1, "E陈二", 56));
        arr.add(new Student(4, "e刘一", 96));
        arr.add(new Student(5, "s李四", 87));
        arr.add(new Student(2, "T王五", 76));

        arr.removeIf(student -> student.getScore() < 60);

        arr.forEach(System.out::println);

    }
}
