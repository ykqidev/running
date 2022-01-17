package com.proj.code.tcp.words.manyclient;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 一个客户端从键盘输入英语单词，然后给服务器发送，
 * 服务器接收到这个单词后，把单词“反转”，然后返回给客户端
 * 直到客户端输入byte为止
 */
public class Client {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 6666);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入单词：");
            String s = scanner.nextLine();
            if ("bey".equals(s)) {
                break;
            }
            ps.println(s);

            System.out.println(br.readLine());
        }
        scanner.close();
        br.close();
        isr.close();
        ps.close();
        os.close();
        is.close();
        socket.close();
    }
}
