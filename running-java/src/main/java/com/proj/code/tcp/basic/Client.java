package com.proj.code.tcp.basic;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * TCP网络编程的客服端
 * 1、创建Socket对象，并且指定“服务器”的IP地址和端口号
 * 主动与服务器建立连接
 * <p>
 * 如果服务器没开或IP地址或端口写错了，就会报 java.net.ConnectException: Connection refused: connect
 * <p>
 * 2、通信
 * （1）接受数据
 * （2）发送数据
 * <p>
 * 3、断开
 */
public class Client {
    @Test
    public void client() throws IOException {

        // 1、创建Socket对象，并且指定“服务器”的IP地址和端口号
        // 主动与服务器建立连接
        Socket socket = new Socket("192.168.52.1", 8888);

        // 2、接受数据
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len;
        while ((len = inputStream.read(data)) != -1) {
//            System.out.println(new String(data, 0, len));
            baos.write(data, 0, len);
        }
        System.out.println(baos.toString());

//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("I come here".getBytes());

        // 3.关闭数据
        inputStream.close();
//        outputStream.close();
        socket.close();
    }
}
