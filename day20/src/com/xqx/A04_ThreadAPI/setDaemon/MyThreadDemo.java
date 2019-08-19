package com.xqx.A04_ThreadAPI.setDaemon;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 9:20
 * description:
 * static void sleep(long millis)
 * 使当前正在执行的线程停留（暂停执行）指定的毫秒数
 * void join() 等待这个线程死亡
 * void setDaemon(boolean on)
 * 将此线程标记为守护线程，当运行的线程都是守护线程时，Java虚拟机 将退出
 */
public class MyThreadDemo{
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread("飞机");
        MyThread myThread2 = new MyThread("高铁");
        MyThread myThread3 = new MyThread("汽车");
        //设置循环次数

        // 3.调用start方法启动线程
        myThread1.start();

        myThread2.start();

        myThread3.start();

    }
}
