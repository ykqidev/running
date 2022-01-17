package com.proj.code.lambda;

import com.proj.code.bean.Book;

import java.util.ArrayList;
import java.util.function.Predicate;

public class BookService {

    ArrayList<Book> arr = new ArrayList<>();

    {
        arr.add(new Book(3, "红楼梦", "刘德华", 63));
        arr.add(new Book(1, "三国演义", "周星驰", 53));
        arr.add(new Book(4, "西游记", "张国荣", 29));
        arr.add(new Book(5, "水浒传", "周润发", 56));
        arr.add(new Book(2, "从想你到想你", "柴妹妹", 43));
    }

    public ArrayList<Book> query(Predicate<Book> p) {
        ArrayList<Book> arrayList = new ArrayList<>();
        for (Book book : arr) {
            if (p.test(book)) {
                arrayList.add(book);
            }
        }
        return arrayList;
    }
}
