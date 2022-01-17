package com.proj.code.tcp.words.manyclient;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器要“同时”接收“多个客户端”的连接
 * <p>
 * 所以这里每一个客户端需要一个“线程”来维护它的通信
 */
public class Server {

    @Test
    public void server() throws IOException {

        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            Socket socket = serverSocket.accept();
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println(inetAddress + "已经连接");
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            OutputStream os = null;
            InputStream is = null;
            Scanner scanner = null;
            try {
                os = socket.getOutputStream();
                is = socket.getInputStream();

                scanner = new Scanner(is);
                while (scanner.hasNextLine()) {
                    String s = scanner.nextLine();
                    System.out.println(socket + "输入的单词：" + s);
                    StringBuilder sb = new StringBuilder(s);
                    sb.reverse();

                    os.write((sb + "\n").getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (scanner != null) {
                        scanner.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

