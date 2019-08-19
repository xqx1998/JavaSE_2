package com.xqx.A01_ThreadCreate;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 9:20
 * description:
 * 多线程创建： 继承 Thread 类的方式
 *         1.写一个类继承Thread，重写run方法，将线程需要做的事写在run方法中。
 *         2.创建自定线程的对象
 *         3.调用start方法启动线程
 */
public class MyThreadDemo {
    public static void main(String[] args) {
        //2.创建自定线程的对象
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        // 3.调用start方法启动线程
        myThread1.start();
        myThread2.start();
    }
}
