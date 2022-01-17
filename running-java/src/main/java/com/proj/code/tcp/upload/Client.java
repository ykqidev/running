package com.proj.code.tcp.upload;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 每一个客户端，可以给服务器上传文件
 * 服务器接收到文件，放到服务器的upload文件夹中，并且接收往后，给客户端返回“上传成功”
 */
public class Client {

    @Test
    public void client() throws IOException {

        // 1、连接服务器
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 7777);

        // 2、指定要上传的文件，选择要上传的文件
        System.out.println("请输入上传文件地址：");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        File file = new File(filePath);
        if (!file.isFile()) {
            throw new RuntimeException("输入的上传文件地址错误");
        }

        // 3、上传文件名和文件内容
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // 发送文件名
        dos.writeUTF(file.getName());

        // 发送文件内容
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] data = new byte[1024];
        int len;
        while ((len = bis.read(data)) != -1) {
            dos.write(data, 0, len);
        }

        // 半关闭，只关闭写的通道，不关闭读的通道
        socket.shutdownOutput();

        // 4、接收服务器的结果
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());

        // 5、关闭
        scanner.close();
        dos.close();
        br.close();
        bis.close();
        socket.close();
    }
}
