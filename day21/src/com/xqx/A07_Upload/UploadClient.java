package com.xqx.A07_Upload;

import java.io.*;
import java.net.Socket;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/18 18:09
 * description:
 * //前提：创建Socket对象，和服务器建立连接
 *
 *         //1、从本地硬盘中读取要上传的文件
 *
 *         //2、使用网络输出流将内容写给服务器
 *
 *         //6、使用网络输入流读取服务器发回的消息
 */
public class UploadClient {
    public static void main(String[] args) throws IOException {
        // 前提：创建Socket对象，和服务器建立连接
        // Socket socket = new Socket("192.168.84.146", 10086);
        Socket socket = new Socket("127.0.0.1", 10010);
        // 1.从本地硬盘中读取要上传的文件
        // 定义要上传的文件
        File uploadFile = new File("G:\\DarkHorseCode\\JavaSE_2\\day21\\你猜猜这是啥.mp4");
        //创建字节输入流读取文件
        FileInputStream fileInputStream = new FileInputStream(uploadFile);
        // 2.使用网络输出流将内容写给服务器
        OutputStream outputStream = socket.getOutputStream();
        //向网络输出流中写上传的文件名称 并刷新
        outputStream.write(uploadFile.getName().getBytes());
        outputStream.flush();
        // 使用while循环读写
        byte[] bytes = new byte[1024];
        int len = 0;
        //读硬盘文件  写入网络流中
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
        //向服务器发送结束标记
        socket.shutdownOutput();
        // 3.使用网络输入流读取服务器发回的消息
        InputStream inputStream = socket.getInputStream();
        len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        //释放资源
        fileInputStream.close();
        socket.close();
    }

}
