package com.proj.code.tcp.basic;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP网络编程的服务端
 *
 * 步骤：
 * 1、创建一个ServerSocket的对象，指定IP地址和监听的端口号
 *    IP如果没有指定，那么就默认是运行该程序的本机地址
 *
 * 2、监听并接受客户端的连接
 *    如果没有人连接，那么该方法就会阻塞
 *
 * 3、如果有人连接，就可以进行通信
 * （1）接受数据
 * （2）发送数据
 *
 * 4、断开连接
 * （1）关闭从socket获取的输入输出流对象，也会导致socket关闭
 *     习惯上还是会先关闭IO流，然后关闭socket.
 * （2）一旦关闭就不能再通信了，只能重新连接
 * （3）TCP程序最好能够正确关闭，应该TCP程序是面向连接，
 *  TCP程序的连接之前有“三次握手”，关闭时“四次挥手”才能关闭。
 *  一次TCP连接的成本很高，因此要珍惜。
 *
 */
public class Server {
    @Test
    public void server() throws IOException {
        // 1、创建一个ServerSocket的对象，指定IP地址和监听的端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("等待你的连接...");
        // 2、监听（接受）客户端的连接
        Socket accept = serverSocket.accept();
        InetAddress inetAddress = accept.getInetAddress();
        System.out.println(inetAddress + "已经连接进来");
        // 3、发送数据
        // 这里发送数据，就是要写数据，这个数据是写网络中，写给客户端的
        // 写数据就要用到输出流
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("北京欢迎你".getBytes());

//        InputStream inputStream = accept.getInputStream();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        byte[] data = new byte[1024];
//        int len;
//        while ((len = inputStream.read(data)) != -1) {
//            baos.write(data, 0, len);
//        }
//        System.out.println(baos.toString());

        // 4、如果不通信了，就断开连接
        outputStream.close();
//        inputStream.close();
        accept.close();

        // 5、如果需要，关闭服务器
        serverSocket.close();
    }
}
