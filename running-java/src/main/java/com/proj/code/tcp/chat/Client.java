package com.proj.code.tcp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 群聊的客户端：
 * （1）从键盘输入消息，发送
 * （2）接收大家的消息
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 1、连接服务器
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8888);
        // 2、启动两个线程
        new SendThread(socket).start();
        new ReceiveThread(socket).start();
    }

    static class SendThread extends Thread {
        private Socket socket;

        public SendThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            PrintStream ps = null;
            try {
                ps = new PrintStream(socket.getOutputStream());
                while (true) {
                    System.out.println("请输入要发送的信息：");
                    String message = scanner.nextLine();
                    // 给服务器发送消息
                    ps.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    ps.close();
                }
                scanner.close();
            }
        }
    }


    static class ReceiveThread extends Thread {
        private Socket socket;

        public ReceiveThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
