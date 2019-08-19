package com.xqx.A04_PrintStream;

import java.io.*;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 14:45
 * description:
 */
public class PintStreamCopyDemo {
    public static void main(String[] args) {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("day19//src//com//xqx//A04_PrintStream//PrintStreamDemo.java"));
            PrintWriter printWriter = new PrintWriter("day19//test.txt");
        ) {
            char[] chars = new char[1024];
            int len = 0;
            while ((len=bufferedReader.read(chars))!=-1){
                printWriter.write(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
