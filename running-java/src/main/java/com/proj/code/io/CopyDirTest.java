package com.proj.code.io;

import java.io.File;
import java.io.IOException;

public class CopyDirTest {

    public static void main(String[] args) {

        try {
            copyDir(new File("C:/Users/Administration/Desktop/outPutFile"),new File("C:/Users/Administration/Desktop/inputFile"));
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copyDir(File srcFile, File descFile) throws IOException {
        if (descFile.isFile() || !descFile.isDirectory()) {
            throw new IOException(descFile.getPath() + "不是一个合法的目录");
        }

        if (descFile.getPath().contains(srcFile.getPath())) {
            throw new IOException("不能把父目录复制到自己的子目录中");
        }

//        if (srcFile.isDirectory()) {
//            String filePath = descFile.getPath() + "/" + srcFile.getName();
//            File parentFile = new File(filePath);
//            parentFile.mkdir();
//
//            File[] listFiles = srcFile.listFiles();
//            if (listFiles != null) {
//                for (File listFile : listFiles) {
//                    copyDir(listFile, parentFile);
//                }
//            }
//        } else if (srcFile.isFile()) {
//            String filePath = descFile.getPath() + "/" + srcFile.getName();
//            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
//            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
//
//            byte[] data = new byte[1024];
//            int len;
//            while ((len = bis.read(data)) != -1) {
//                bos.write(data, 0, len);
//            }
//            bis.close();
//            bos.close();
//        }
    }
}
