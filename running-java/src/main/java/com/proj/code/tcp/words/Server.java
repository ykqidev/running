package com.proj.code.tcp.words;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = serverSocket.accept();
        InetAddress inetAddress = socket.getInetAddress();
        System.out.println(inetAddress + "已经连接");

        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

        Scanner scanner = new Scanner(is);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println("输入的单词：" + s);
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            os.write((sb + "\n").getBytes());
        }
        scanner.close();
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
    }
}
