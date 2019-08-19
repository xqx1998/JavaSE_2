package com.xqx.A01_byteStream_.A01_bufferStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 8:52
 * description:
 */
public class NamingDeviceDemo {
    public static void main(String[] args) throws IOException {
        //创建一个字符缓冲输入流对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day18//src//名单.txt"));
        //创建list集合存储学生姓名
        ArrayList<String> names = new ArrayList<>();
        //获取数据，附加到list中
        while (bufferedReader.ready()) {
            names.add(bufferedReader.readLine());
        }
        //释放资源
        bufferedReader.close();
        //打印幸运学生姓名
        System.out.println("幸运学生："+names.get(new Random().nextInt(names.size())));
    }
}
