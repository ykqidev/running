package com.proj.code.io;

import java.io.*;

public class CopyFileTest {
    public static void main(String[] args)  {
//        String srcPath = "C:/Users/Administration/Desktop/1.txt";
//        String destPath = "C:/Users/Administration/Desktop/3.txt";
        String srcPath = "E:temp/011_Hadoop.rar";
        String destPath = "C:/Users/Administration/Desktop/Hadoop.rar";
        try {
            copyFile(srcPath, destPath);
            System.out.println("复制成功");
        } catch (IOException e) {
            System.out.println("复制失败");
            e.printStackTrace();
        }
    }

    public static void copyFile(String srcPath, String destPath) throws IOException {

        FileInputStream fis = new FileInputStream(srcPath);
        FileOutputStream fos = new FileOutputStream(destPath);

        byte[] data = new byte[1024];

        int len;
        while ((len = fis.read(data)) != -1) {
//            System.out.print(new String(data, 0, len));
            fos.write(data,0,len);
        }

        fis.close();
        fos.close();
    }
    public static void copyFile1(String srcPath, String destPath) throws IOException {

        FileReader fr = new FileReader(srcPath);
        FileWriter fw = new FileWriter(destPath);

        char[] data = new char[10];

        int len;
        while ((len = fr.read(data)) != -1) {
//            System.out.print(new String(data, 0, len));
            fw.write(data,0,len);
        }

        fr.close();
        fw.close();
    }
}
