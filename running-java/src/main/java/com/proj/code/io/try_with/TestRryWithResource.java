package com.proj.code.io.try_with;

import com.proj.code.constant.CodeConstants;
import org.junit.Test;

import java.io.*;

/**
 * jdk1.7引入的，
 * try...with..resources
 * <p>
 * 语法结构
 * try(资源的声明){
 * ...
 * }catch(异常类型 e){
 * <p>
 * }
 * finally不用写，使用完了，这个资源自动关闭
 */
public class TestRryWithResource {

    @Test
    public void method01() {
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

        try (FileInputStream fis = new FileInputStream(srcPath);
             FileOutputStream fos = new FileOutputStream(destPath);

             // 在fis基础上增加缓冲效果，装饰
             BufferedInputStream bus = new BufferedInputStream(fis);
             // 在fos基础上增加缓冲效果，装饰
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            // 数据的流向：srcPath --> fis --> bus --> 字节数组（桶）--> bos --> fos --> destPath
            // 2.一边读一边写
            byte[] data = new byte[1024];
            int len;
            while ((len = bus.read(data)) != -1) {
                bos.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
