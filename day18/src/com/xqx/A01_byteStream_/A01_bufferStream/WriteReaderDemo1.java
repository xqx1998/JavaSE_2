package com.xqx.A01_byteStream_.A01_bufferStream;


import java.io.*;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/13 11:54
 * description:  编码转换
 */
public class WriteReaderDemo1{
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream("day18//src//utf-8.txt"), "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day18//src//gbk.txt", true), "gbk");

        char[] chars = new char[1024];
        int len = 0;
        while ((len = isr.read(chars))!=-1){
            osw.write(chars,0,len);
        }

        isr.close();
        osw.close();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("day18//src//gbk.txt"));
        byte[] bytes = new byte[1024];
        int len1 = 0;
        while ((len = bufferedInputStream.read(bytes))!=-1)
            System.out.println(new String(bytes,0,len,"gbk"));

        System.out.println("---------------高效字符缓冲流-读");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("day18//src//gbk.txt"), "gbk"));
        char[] chars1 = new char[1024];
        int len2 = 0;
        while ((len2 = bufferedReader.read(chars1))!=-1){
            System.out.println(new String(chars1, 0, len2));
        }
        while (bufferedReader.ready()){

        }
    }

}
