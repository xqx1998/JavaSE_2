package com.xqx.A06_practice.Demo3_wait_notify;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 16:55
 * description:
 */
public class Test {
    public static void main(String[] args) {
        Object o = new Object();

        MyThread1 myThread1 = new MyThread1(o);
        MyThread2 myThread2 = new MyThread2(o);

        myThread1.setName("father");
        myThread2.setName("son");

        myThread2.start();
        myThread1.start();

    }
}
