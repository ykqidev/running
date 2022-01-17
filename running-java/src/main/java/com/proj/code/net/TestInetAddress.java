package com.proj.code.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {

    @Test
    public void method03() throws UnknownHostException {

        // 在这里(byte)192强转 不会报错  InetAddress.getByAddress里面有特殊处理
        byte[] address = new byte[]{(byte)192,(byte)168,52,1};
        InetAddress inetAddress = InetAddress.getByAddress(address);
        System.out.println("inetAddress:" + inetAddress);
        String hostAddress = inetAddress.getHostAddress();
        String hostName = inetAddress.getHostName();
        System.out.println("hostAddress:" + hostAddress);
        System.out.println("hostName:" + hostName);

    }

    @Test
    public void method02() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println("inetAddress:" + inetAddress);
        String hostAddress = inetAddress.getHostAddress();
        String hostName = inetAddress.getHostName();
        System.out.println("hostAddress:" + hostAddress);
        System.out.println("hostName:" + hostName);

    }

    @Test
    public void method01() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost:" + localHost);
        String hostAddress = localHost.getHostAddress();
        String hostName = localHost.getHostName();
        System.out.println("hostAddress:" + hostAddress);
        System.out.println("hostName:" + hostName);

    }
}
