package com.xqx.A04TCPReturn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 20:24
 * description:
 * TCP接收数据的步骤
 *         1:创建服务器端的Socket对象(ServerSocket)
 *         2:获取输入流，读数据，并把数据显示在控制台
 *         3:释放资源
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 1:创建服务器端的Socket对象(ServerSocket)
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket accept = serverSocket.accept();
        // 2:获取输入流，读数据，并把数据显示在控制台
        InputStream is = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println("数据是："+new String(bytes,0,len));

        //回应客户端
        OutputStream os = accept.getOutputStream();
        os.write("来自服务端的回应".getBytes());

        // os.close();
        // 3:释放资源
        // is.close();
        serverSocket.close();

    }
}
