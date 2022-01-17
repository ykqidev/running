package com.proj.code.udp.basic;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * DatagramSocket
 * DatagramPacket
 *
 * UDP的发送端
 */
public class Send {

    @Test
    public void send() throws IOException {

        // 1、先创建一个DatagramSocket
        // 可以不指定端口号和IP地址，自动选择端口号，ip默认地址
        DatagramSocket ds = new DatagramSocket();

        // 2、准备发送的数据
        String sendStr = "今天天气真好";
        byte[] data = sendStr.getBytes();

        // 3、把数据包装成一个数据报
        /*
         * 参数一：字节数组，就是要发送的数据
         * 参数二：数据的长度
         * 参数三：接收方的主机名和IP地址
         * 参数四：接收方监听的端口号
         */
        InetAddress address = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
        DatagramPacket dp = new DatagramPacket(data, data.length, address, 3333);

        // 4、通过socket对象发送数据报
        ds.send(dp);
        System.out.println("数据发送完毕");

        // 5、关闭
        ds.close();
    }
}
