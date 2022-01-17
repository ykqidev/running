package com.proj.code.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、使用 NIO 完成网络通信的三个核心：
 * <p>
 * 1. 通道（Channel）：负责连接
 * <p>
 * java.nio.channels.Channel 接口：
 * |--SelectableChannel
 * |--SocketChannel
 * |--ServerSocketChannel
 * |--DatagramChannel
 * <p>
 * |--Pipe.SinkChannel
 * |--Pipe.SourceChannel
 * <p>
 * 2. 缓冲区（Buffer）：负责数据的存取
 * <p>
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 */
public class TestBlockingNIO {

    @Test
    public void client() {
        SocketChannel sChannel = null;
        FileChannel inChannel = null;
        try {
            // 1.获取通道
            sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));

            inChannel = FileChannel.open(Paths.get("3.txt"), StandardOpenOption.READ);
            // 2.分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //3.读取本地文件，并发送到服务器
            while (inChannel.read(buf) != -1) {
                buf.flip();
                sChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭通道
            if (sChannel != null) {
                try {
                    sChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 服务端
     * 1.获取通道
     * 2.绑定连接 端口
     * 3.获取客户端连接的通道
     * 4.分配指定大小的缓冲区
     * 5.指定客户端的数据，并保持到本地
     * 6.关闭通道
     */
    @Test
    public void server() throws IOException {

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("file/input/2.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        ssChannel.bind(new InetSocketAddress(9999));

        SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (sChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        ssChannel.close();
        outChannel.close();
        sChannel.close();
    }
}
