package com.proj.code.io.buffer;

import com.proj.code.constant.CodeConstants;

import java.io.*;

public class BufferedTest {

    public static void main(String[] args) {
        String srcPath = CodeConstants.FILE_ROOT_INPUT_PATH + "1.txt";
        String destPath = CodeConstants.FILE_ROOT_OUTPUT_PATH + "copy1.txt";
        try {
            long startTime = System.currentTimeMillis();
            copyFile(srcPath, destPath);
            long endTime = System.currentTimeMillis();
            System.out.println("复制成功,耗时：" + (endTime - startTime));
        } catch (IOException e) {
            System.out.println("复制失败");
            e.printStackTrace();
        }
    }

    public static void copyFile(String srcPath, String destPath) throws IOException {

        FileInputStream fis = new FileInputStream(srcPath);
        FileOutputStream fos = new FileOutputStream(destPath);

        // 在fis基础上增加缓冲效果，装饰
        BufferedInputStream bus = new BufferedInputStream(fis);
        // 在fos基础上增加缓冲效果，装饰
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 数据的流向：srcPath --> fis --> bus --> 字节数组（桶）--> bos --> fos --> destPath
        // 2.一边读一边写
        byte[] data = new byte[1024];
        int len;
        while ((len = bus.read(data)) != -1) {
            bos.write(data, 0, len);
        }

        //3.关闭IO流
        //可以只关闭最外层的，但是如果要关闭全部的话，这里只有顺序要求
        //先关内层，再关外层
        bus.close();
        bos.close();

        fis.close();
        fos.close();
    }
}
