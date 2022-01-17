package com.proj.code.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileUtil {

    public static String[] getFileName(String path) {
        File file = new File(path);
        return file.list();
    }

    public static void getAllFileName(String path, ArrayList<String> fileName) {
        File file = new File(path);
        File[] files = file.listFiles();
        String[] names = file.list();
        if (names != null)
            fileName.addAll(Arrays.asList(names));
        if (files != null) {
            for (File a : files)
                if (a.isDirectory()) {
                    getAllFileName(a.getAbsolutePath(), fileName);
                }
        }
    }

    /**
     * 获取一个文件或目录的大小
     */
    public static long getLength(File file) {
        long length = 0;
        if (file.isFile()) {
            length = file.length();
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File listFile : listFiles) {
                    length += getLength(listFile);
                }
            }
        }
        return length;

    }

    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File listFile : listFiles) {
                    deleteFile(listFile);
                }
            }
        }

        file.delete();
    }
}
