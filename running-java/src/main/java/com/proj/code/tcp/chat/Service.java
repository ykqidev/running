package com.proj.code.tcp.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * TCP 群聊
 */
public class Service {

    // 用集合记录所有在线的客户端
    private static ArrayList<Socket> online = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 1、创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器已经启动成功");
        // 2、接收n多人连接
        while (true) {
            Socket socket = serverSocket.accept();
            String ip = socket.getInetAddress().getHostAddress();
            System.out.println(ip + "连接成功");

            // 把当前客户端要添加到online的集合中
            online.add(socket);

            // 每一个客户端需要线程
            new MessageThread(socket).start();
        }
    }

    static class MessageThread extends Thread {
        private Socket socket;

        public MessageThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // 一上来，就给大家打招呼，xx上线了
            sendToOther(socket.getInetAddress().getHostAddress() + "上线了");

            // 不断地接收当前客户端的消息，并且给其他客户端转发消息
            // 第一步接收数据
            try {
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String line;
                // 给其他客户端转发消息
                while ((line = br.readLine()) != null) {
                    sendToOther(socket.getInetAddress().getHostAddress() + "：" + line);
                }
            } catch (IOException e) {
                sendToOther(socket.getInetAddress().getHostAddress() + "掉线了");
                e.printStackTrace();
            }
            sendToOther(socket.getInetAddress().getHostAddress() + "下线了");
        }

        // 转发消息
        private void sendToOther(String message) {
            try {
                // 遍历所有的online的socket，每个人发一份，可以排除自己
                for (Socket socket : online) {
                    if (this.socket != socket) {
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        ps.println(message);
                    }
                }
            } catch (IOException e) {
                sendToOther(socket.getInetAddress().getHostAddress() + "掉线了");
                e.printStackTrace();
            }
        }
    }
}
