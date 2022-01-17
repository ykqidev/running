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

public class TestBlockingNIO2 {

    @Test
    public void client() throws IOException {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        FileChannel inChannel = FileChannel.open(Paths.get("3.txt"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (inChannel.read(buf)!= -1){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        sChannel.shutdownOutput();
        System.out.println("-------------------");
        int len;
        while ((len = sChannel.read(buf)) != -1){
            buf.flip();
            System.out.println(new String(buf.array(),0,len));
            buf.clear();
        }

        inChannel.close();
        sChannel.close();
    }


    @Test
    public void server() throws IOException {

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("file/input/2.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        ssChannel.bind(new InetSocketAddress(9999));

        SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (sChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //给客户端反馈
        buf.put("服务端接收数据成功".getBytes());
        buf.flip();
        sChannel.write(buf);

        sChannel.close();
        ssChannel.close();
        outChannel.close();







    }
}
