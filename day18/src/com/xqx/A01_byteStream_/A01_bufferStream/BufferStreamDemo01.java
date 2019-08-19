package com.xqx.A01_byteStream_.A01_bufferStream;


import java.io.*;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/13 9:36
 * description:
 */
public class BufferStreamDemo01 {
    public static void main(String[] args) throws IOException {
        //创建路径变量
        String path = "day18/src/utf-8.txt";
        //创建字节缓冲输出流对象
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path,true));
        //循环写入数据
        for (int i = 0; i < 10; i++) {
            bufferedOutputStream.write("好，我很帅\n".getBytes());
        }
        //释放资源
        bufferedOutputStream.close();

        //创建字节缓冲输入流对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        //读取数据
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len=bufferedInputStream.read(bytes))!=-1) {
            System.out.print(new String(bytes,0, len));
        }
        //释放资源
        bufferedInputStream.close();

    }
}
