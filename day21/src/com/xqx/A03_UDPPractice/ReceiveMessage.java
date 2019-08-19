package com.xqx.A03_UDPPractice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 18:05
 * description:
 * UDP接收数据的步骤
 *         1:创建接收端的Socket对象(DatagramSocket)
 *         2:创建一个数据包，用于接收数据
 *         3:调用DatagramSocket对象的方法接收数据
 *         4:解析数据包，并把数据在控制台显示
 *         5:关闭接收端
 */
public class ReceiveMessage {
    public static void main(String[] args) throws IOException {
        while (true) {
            //1:创建接收端的Socket对象(DatagramSocket) 参数为端口号
            DatagramSocket datagramSocket = new DatagramSocket(10086);
            // 2:创建一个数据包，用于接收数据
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            // 3:调用DatagramSocket对象的方法接收数据
            datagramSocket.receive(datagramPacket);
            System.out.println("datagramPacket.getAddress() = " + datagramPacket.getAddress());
            // 4:解析数据包，并把数据在控制台显示
            System.out.println("接收到的数据：" + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
            // 5:关闭接收端
            datagramSocket.close();
        }
    }
}
