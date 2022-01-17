package com.proj.code.udp.basic;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP的接收方
 */
public class Receive {
    @Test
    public void receive() throws IOException {

        // 1、创建DatagramSocket，需要制定端口号
        DatagramSocket ds = new DatagramSocket(3333);

        // 2、准备接收数据的数据报和字节数组
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        System.out.println("等待着数据...");

        // 3、接收数据
        ds.receive(dp);

        // 4、显示数据
        System.out.println(new String(data, 0, data.length));

        // 5、关闭
        ds.close();

    }
}
