package com.proj.code.io.buffer;

import java.nio.ByteBuffer;

public class ByteBufferTest {
    public static void main(String[] args) {
        String str = "abcde";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());

        buf.flip();
        System.out.println("-------------------------------");
        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 2);
        System.out.println("limit: " + buf.limit());
        System.out.println("position: " + buf.position());

        //mark 标记
        System.out.println("--------------mark-------------------");
        buf.mark();
        buf.get(dst, 2, 2);
        System.out.println("limit: " + buf.limit());
        System.out.println("position: " + buf.position());

        System.out.println("--------------reset-------------------");
        buf.reset();
        System.out.println("limit: " + buf.limit());
        System.out.println("position: " + buf.position());

        //判断缓冲区中是否还有剩余数据
        if (buf.hasRemaining()) {
            System.out.println(buf.remaining());

        }
    }
}
