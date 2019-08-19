package com.xqx.A02_ThreadName;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 9:20
 * description:
 * 多线程创建： 继承 Thread 类的方式
 *         1.写一个类继承Thread，重写run方法，将线程需要做的事写在run方法中。
 *         2.创建自定线程的对象
 *         3.调用start方法启动线程
 *
 *   void setName(String name) 将此线程的名称更改为等于参数name
 *   String getName() 返回此线程的名称
 *   Thread currentThread() 返回对当前正在执行的线程对象的引用
 */
public class MyThreadDemo{
    public static void main(String[] args) {
       /* //2.创建自定线程的对象
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setName("风清扬");
        myThread2.setName("令狐冲");*/

        MyThreadName myThread1 = new MyThreadName("风清扬");
        MyThreadName myThread2 = new MyThreadName("令狐冲");

        // 3.调用start方法启动线程
        myThread1.start();
        myThread2.start();

        for (int i = 0; i < 100; i++) {
            //获取当前线程名称并打印
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }
}
