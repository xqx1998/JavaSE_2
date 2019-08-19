package com.xqx.A03_System_in_out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 11:53
 * description:
 * public static ﬁnal InputStream in：标准输入流。通常该流对应于键盘输入或由主机环境或用户指定的 另一个输入源
 * public static ﬁnal PrintStream out：标准输出流。通常该流对应于显示输出或由主机环境或用户指定的 另一个输出目标
 */
public class SystemInDemo {
    public static void main(String[] args) throws IOException {
        /*InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        String s = bufferedReader.readLine();
        // bufferedReader.close();
        System.out.println(s);*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入一个字符串：");
        String line = br.readLine();
        System.out.println("你输入的字符串是：" + line);

        System.out.println("请输入一个整数：");
        int i = Integer.parseInt(br.readLine());
        System.out.println("你输入的整数是：" + i);

        /*Scanner sc  =  new Scanner(System.in);
        System.out.println(sc.next());*/

    }
}
