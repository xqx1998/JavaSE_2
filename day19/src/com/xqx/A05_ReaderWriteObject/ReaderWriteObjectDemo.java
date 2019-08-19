package com.xqx.A05_ReaderWriteObject;

import java.io.*;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 15:56
 * description:
 */
public class ReaderWriteObjectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写对象
        write();
        //读对象
        reader();
    }

    private static void write() throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("day19//stu.txt"));
        Student student = new Student("倖权祥", 21);
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }
    private static void reader() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("day19//stu.txt"));
        Object o = objectInputStream.readObject();
        System.out.println((Student)o);
    }
}
