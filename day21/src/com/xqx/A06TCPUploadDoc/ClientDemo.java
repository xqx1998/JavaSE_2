package com.xqx.A06TCPUploadDoc;

import java.io.*;
import java.net.Socket;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 20:23
 * description:
 * 客户端：数据来自于键盘录入，直到输入的数据是886，发送数据结束
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 1:创建客户端的Socket对象(Socket)
        Socket socket = new Socket("127.0.0.1",10000);
        // 2:获取输出流，写数据
        OutputStream os = socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        System.out.println("请输入要发送的消息：");
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
            if ("886".equals(line))
                break;
        }

        // 3:释放资源
        br.close();
        // os.close();
        socket.close();
    }
}
