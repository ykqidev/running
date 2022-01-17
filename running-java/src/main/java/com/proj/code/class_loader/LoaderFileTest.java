package com.proj.code.class_loader;

import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class LoaderFileTest {

    @Test
    public void test2() {

        // 1、创建一个Properties对象，用来装加载建立的数据
        Properties pro = new Properties();
        try {
            // 2、要从properties文件中读取数据
            // 先获取当前类的加载器对象
            ClassLoader loader = LoaderFileTest.class.getClassLoader();
            pro.load(loader.getResourceAsStream("loader/jdbc2.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pro);
    }

    @Test
    public void test1() {
        ClassLoader loader = LoaderFileTest.class.getClassLoader();
        Properties pro = new Properties();
        try {
            pro.load(loader.getResourceAsStream("loader/jdbc1.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pro);
    }
}
