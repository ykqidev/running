package com.proj.code.tcp.upload;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器要“同时”接收“多个客户端”的连接
 * <p>
 * 所以这里每一个客户端需要一个“线程”来维护它的通信
 */
public class Server {

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);

        while (true) {
            Socket socket = serverSocket.accept();
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println(inetAddress + "已经连接");
            new FileHandler(socket).start();
        }
    }

    static class FileHandler extends Thread {
        private static final String uploadPath = "resources/upload/";

        private Socket socket;

        public FileHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            DataInputStream dis = null;
            BufferedOutputStream bos = null;
            PrintStream ps = null;
            try {
                // 文件名：客户端传过来
                // 1、接收文件名，文件名是一个字符串
                // 因为文件名是字符串，而文件内容是字节数据，这里用DataInputStream
                dis = new DataInputStream(socket.getInputStream());
                String fileName = dis.readUTF();

                // 2、处理文件名
                String filePath = uploadPath + System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
                bos = new BufferedOutputStream(new FileOutputStream(filePath));

                // 3、接收文件的内容
                // 因为不知道是什么文件，不能用字符流，只能用字节流
                byte[] data = new byte[1024];
                int len;
                while ((len = dis.read(data)) != -1) {
                    bos.write(data, 0, len);
                }

                // 4、给客户端返回“上传成功”一句话
                ps = new PrintStream(socket.getOutputStream());
                ps.println("上传成功");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 关闭流
                try {
                    if (dis != null) {
                        dis.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}