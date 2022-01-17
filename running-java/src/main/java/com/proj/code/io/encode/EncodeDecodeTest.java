package com.proj.code.io.encode;

import com.proj.code.constant.CodeConstants;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class EncodeDecodeTest {
    public static final String GBK_FILE_PATH = CodeConstants.FILE_ROOT_PATH + "gbk.txt";
    public static final String UTF8_FILE_PATH = CodeConstants.FILE_ROOT_PATH + "utf.txt";

    @Test
    public void method02() throws IOException {

//        File file = new File(UTF8_FILE_PATH);
//        readFile(file);
//        System.out.println("查看成功");

        File srcFile = new File(GBK_FILE_PATH);
        File descFile = new File(UTF8_FILE_PATH);
        readAndWriter(srcFile, descFile);
        System.out.println("查看成功");
    }


    @Test
    public void method01() throws IOException {
        File srcFile = new File(GBK_FILE_PATH);
        File descFile = new File(UTF8_FILE_PATH);
        System.out.println(srcFile.getCanonicalPath());
    }

    /**
     * 面试题：请编写代码吧一个GBK的文本文件内容读取后存储到一个UTF-8的文本件中。（当前平台什么资费编码不知道）
     */
    public static void readAndWriter(File srcFile, File descFile) {
        try (
//                // 文件流
//                FileInputStream fis = new FileInputStream(srcFile);
//                FileOutputStream fos = new FileOutputStream(descFile);
//
//                // 缓冲流
//                BufferedInputStream bis = new BufferedInputStream(fis);
//                BufferedOutputStream bos = new BufferedOutputStream(fos);
//
//                // 字符流
//                InputStreamReader isr = new InputStreamReader(bis, "GBK");
//                OutputStreamWriter osw = new OutputStreamWriter(bos, StandardCharsets.UTF_8);

                InputStreamReader isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(srcFile)), "GBK");
                OutputStreamWriter osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(descFile)), StandardCharsets.UTF_8);
        ) {
            char[] data = new char[1024];
            int len;
            while ((len = isr.read(data)) != -1) {
                osw.write(data, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(File file) {

        try (FileReader fr = new FileReader(file)) {
            char[] data = new char[1024];
            int len;
            while ((len = fr.read(data)) != -1) {
                System.out.println(new String(data, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        FileReader fr;
//        try  {
//            fr = new FileReader(file);
//            char[] data = new char[1024];
//            int len;
//            while ((len = fr.read(data)) != -1) {
//                System.out.println(new String(data, 0, len));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
