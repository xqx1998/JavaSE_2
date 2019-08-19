package com.xqx.A02_UDP;

import java.io.IOException;
import java.net.*;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 18:05
 * description:
 * UDP发送数据的步骤
 *         1:创建发送端的Socket对象(DatagramSocket)
 *         2:创建数据，并把数据打包
 *         3:调用DatagramSocket对象的方法发送数据
 *         4:关闭发送端
 */
public class Demo01Send {
    public static void main(String[] args) throws IOException {
        // 1:创建发送端的Socket对象(DatagramSocket)
        DatagramSocket datagramSocket = new DatagramSocket();
        // 2:创建数据，并把数据打包
        byte[] bytes = "Hello UDP, come On".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),10086);
        // 3:调用DatagramSocket对象的方法发送数据
        datagramSocket.send(datagramPacket);
        // 4:关闭发送端
        datagramSocket.close();
    }
}
