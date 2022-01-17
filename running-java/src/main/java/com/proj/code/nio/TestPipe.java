package com.proj.code.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Java NIO管道是2个线程之间的单向数据连接。pipe有一个source通道和一个sink通道。
 * 数据会被写入到sink通道，从source通道读取。
 */
public class TestPipe {

    @Test
    public void test() throws IOException {
        Pipe pipe = Pipe.open();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("通过单向管道发送数据".getBytes());
        buf.flip();
        sinkChannel.write(buf);

        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(),0,len));

        sinkChannel.close();
        sourceChannel.close();

    }
}
