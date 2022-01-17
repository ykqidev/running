package com.proj.code.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

    @Test
    public void method02() throws IOException {

        //1.创建IO流
        //需要制定一个参数，表明从哪个文件读取
        FileInputStream fis = new FileInputStream("C:/Users/Administration/Desktop/1.txt");
        //2.进行读取操作
        byte[] data = new byte[10];

        //如果data数组无法装下文件的所有内容，可以用循环，反复读
        int len = 0;
//        while (true) {
//            len = fis.read(data);
//            if (len == -1) {
//                break;
//            }
//            System.out.print(new String(data, 0, len));
//        }

        while ((len = fis.read(data))!=-1) {
            System.out.print(new String(data, 0, len));
        }

        //3.关闭
        fis.close();

    }

    @Test
    public void method01() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:/Users/Administration/Desktop/1.txt");
        byte[] data = new byte[10];
        int len = fileInputStream.read(data);
        System.out.println(len);
//        String s = new String(data);
        String s = new String(data, 0, len);
        System.out.println(s);

    }
}
