package com.proj.code.io;

import com.proj.code.constant.CodeConstants;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class SystemTest {

    @Test
    public void scannerTest() throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileInputStream(CodeConstants.FILE_ROOT_INPUT_PATH + "2.txt"));

        while (scanner.hasNext()){
            String s = scanner.nextLine();
            System.out.println(s);
        }

        scanner.close();

    }

    @Test
    public void systemOutTest() throws FileNotFoundException {
        System.setOut(new PrintStream(CodeConstants.FILE_ROOT_INPUT_PATH + "1.txt"));
        System.out.println("hello");
        System.out.println("world");
        System.out.println("java");
    }
}
