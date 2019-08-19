package com.xqx.A04TCPReturn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 20:23
 * description:
 * TCP发送数据的步骤
 *         1:创建客户端的Socket对象(Socket)
 *         2:获取输出流，写数据
 *         3:释放资源
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 1:创建客户端的Socket对象(Socket)
        Socket socket = new Socket("127.0.0.1",10000);
        // 2:获取输出流，写数据
        OutputStream os = socket.getOutputStream();
        os.write("hello,tcp我来了".getBytes());

        //接收服务端的消息
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println("数据："+new String(bytes,0,len));
        // 3:释放资源
        // os.close();
        socket.close();
    }
}
