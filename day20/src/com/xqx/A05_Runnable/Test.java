package com.xqx.A05_Runnable;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 11:57
 * description:
 */
public class Test {
    public static void main(String[] args) {
        //创建实现类对象，创建线程对象，将实现类对象交给线程对象
        MyRunnable myRunnable = new MyRunnable();
        //创建线程对象
        Thread thread1 = new Thread(myRunnable);
        //创建线程对象，带名称
        Thread thread2 = new Thread(myRunnable,"高铁");
        //设置线程名
        thread1.setName("飞机");
        //调用start方法启动线程
        thread1.start();
        thread2.start();
    }
}
