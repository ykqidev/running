package com.proj.code.udp.many;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class GroupSending {
    private volatile static boolean exit = false;
    private static Scanner scanner = new Scanner(System.in);
    private static String userName;//区别谁发送的


    public static void main(String[] args) throws IOException {
        // 1、创建一个Socket，可以广播的socket,指定端口号为2222
        MulticastSocket socket = new MulticastSocket(2222);
        // 2、设置广播的IP地址
        InetAddress ip = InetAddress.getByName("230.0.0.1");
        // 3、把当前的socket加入到广播组
        socket.joinGroup(ip);
        // 4、是否给自己也发一份 false表示给自己发
        socket.setLoopbackMode(false);

        System.out.println("请输入用户名");
        userName = scanner.nextLine();

        // 因为当前程序即是发送方也是接收方，所以用两个线程，分别处理发送和接收，才能同时进行发送和接收
        SendThread s = new SendThread(socket, ip);
        ReceiveThread r = new ReceiveThread(socket);

        s.start();
        r.start();

        try {
            s.join(); // 等发送结束，再关闭
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        socket.close();
        scanner.close();
    }


    static class SendThread extends Thread {

        private MulticastSocket socket;
        private InetAddress ip;

        public SendThread(MulticastSocket socket, InetAddress ip) {
            this.socket = socket;
            this.ip = ip;
        }

        @Override
        public void run() {
            try {
                while (!exit) {
                    System.out.println("请输入广播信息：");
                    String message = scanner.nextLine();
                    if ("bye".equals(message)) {
                        exit = true;
                        break;
                    }
                    byte[] data = (userName + "说:" + message).getBytes();
                    DatagramPacket dp = new DatagramPacket(data, data.length, ip, 2222);
                    socket.send(dp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ReceiveThread extends Thread {

        private MulticastSocket socket;

        public ReceiveThread(MulticastSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (!exit) {
                byte[] data = new byte[1024];
                DatagramPacket dp = new DatagramPacket(data, data.length);
                try {
                    socket.receive(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(new String(data, 0, data.length));
            }
        }
    }
}