package com.xqx.A05TCPReturnPractice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 20:24
 * description:
 * 服务器：接收到的数据在控制台输出
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 1:创建服务器端的Socket对象(ServerSocket)
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket accept = serverSocket.accept();
        // 2:获取输入流，读数据，并把数据显示在控制台
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("day21\\src\\com\\xqx\\A05TCPReturnPractice\\message.txt",true));
        while (true) {
            char[] chars = new char[1024];
            int len;
            if ((len = br.read(chars)) != -1) {
                String data = new String(chars, 0, len);
                System.out.println("数据是：" + data);
                bw.write(data);
                bw.flush();
                if ("886".equals(data.trim()))
                    break;
            }
            // 回应客户端
            // bw.write("已接收到数据");
        }
        // os.close();
        // 3:释放资源
        // is.close();
        bw.close();
        serverSocket.close();

    }
}
