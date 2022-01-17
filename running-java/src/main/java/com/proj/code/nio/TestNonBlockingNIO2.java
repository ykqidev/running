package com.proj.code.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Java NIO中的DatagrmChannel是一个能收发UDP包的通道
 */
public class TestNonBlockingNIO2 {

    @Test
    public void send() throws IOException {

        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()){
            String str = scan.next();
            buf.put((new Date().toString() + ":\n" + str).getBytes());
            buf.flip();
            dc.send(buf,new InetSocketAddress("127.0.0.1",9999));
            buf.clear();
        }

        dc.close();
    }


    @Test
    public void receive() throws IOException {

        DatagramChannel dc = DatagramChannel.open();
        
        dc.configureBlocking(false);

        dc.bind(new InetSocketAddress(9999));

        Selector selector = Selector.open();
        
        dc.register(selector, SelectionKey.OP_READ);
        
        while (selector.select() > 0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            
            while (it.hasNext()){
                SelectionKey selectionKey = it.next();
                if(selectionKey.isReadable()){
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    dc.receive(buf);
                    buf.flip();
                    System.out.println(new String(buf.array(),0,buf.limit()));
                    buf.clear();
                }
            }
            it.remove();
        }
    }
}
