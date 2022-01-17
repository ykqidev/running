package com.proj.code.io;

import com.proj.code.constant.CodeConstants;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    @Test
    public void method01() throws IOException {
        FileReader fr = new FileReader(CodeConstants.FILE_ROOT_INPUT_PATH + "1.txt");

        char[] data = new char[10];
        int len;
        while ((len = fr.read(data)) != -1) {
            System.out.print(new String(data, 0, len));
        }
        fr.close();
    }
}
