package com.xqx.A03_UDPPractice.A03_Practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 18:05
 * description:
 * UDP发送数据的步骤
 * 1:创建发送端的Socket对象(DatagramSocket)
 * 2:创建数据，并把数据打包
 * 3:调用DatagramSocket对象的方法发送数据
 * 4:关闭发送端
 * 阳哥：192.168.84.146
 */
public class SendReceiveMessage {
    static String address = "";
    static int port = 0;
    public static void main(String[] args) throws IOException {
        System.out.println("请输入好友的IP地址：");
        Scanner scanner = new Scanner(System.in);
        address = scanner.next().trim();
        System.out.println("请输入好友的端口号");
        port = scanner.nextInt();
        //创建并启动 接收消息线程
        new Thread() {
            @Override
            public void run() {
                try {
                    receive();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //创建并启动 发送消息线程
        new Thread() {
            @Override
            public void run() {
                try {
                    send();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void receive() throws IOException {
        while (true) {
            //1:创建接收端的Socket对象(DatagramSocket) 参数为端口号
            DatagramSocket datagramSocket = new DatagramSocket(port);
            // 2:创建一个数据包，用于接收数据
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            // 3:调用DatagramSocket对象的方法接收数据
            datagramSocket.receive(datagramPacket);
            // 4:解析数据包，并把数据在控制台显示
            System.out.println("接收到的数据：" + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
            // 5:关闭接收端
            datagramSocket.close();
        }
    }

    public static void send() throws IOException {
        // 1:创建发送端的Socket对象(DatagramSocket)
        DatagramSocket datagramSocket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        // 2:创建数据，并把数据打包
        while (true) {
            System.out.println("请输入要发送的数据：");
            // String message = scanner.next();
            List<String> doc = doc();
            String message = "";
            for (int i = 0; i < doc.size(); i++) {


                message = doc.get(i);

                byte[] bytes = message.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(address), port);
                // 3:调用DatagramSocket对象的方法发送数据
                datagramSocket.send(datagramPacket);
            }
            if (message.equals("886"))
                break;
        }
        // 4:关闭发送端
        datagramSocket.close();
    }

    public static List<String> doc(){
        //定义字符输入流对象
        BufferedReader bufferedReader = null;
        //创建集合存储姓名
        ArrayList<String> names = new ArrayList<>();
        //读取姓名文件数据
        try {
            //创建字符输入流
            bufferedReader = new BufferedReader(new FileReader("day20\\src\\homework_day20\\homework_07\\name.txt"));
            //判读 读取
            while (bufferedReader.ready()) {
                names.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if (bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return names;
    }
}
