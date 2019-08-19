package com.xqx.A01_byteStream_.A01_bufferStream;

import java.io.*;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/13 20:18
 * description:
 */
public class Copy_BufferedReaderDemo01 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("day18\\src\\utf-8.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("day18\\src\\utf-8_Copy.txt"));

        while (bufferedReader.ready()) {
            bufferedWriter.write(bufferedReader.readLine());
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();

    }
}
