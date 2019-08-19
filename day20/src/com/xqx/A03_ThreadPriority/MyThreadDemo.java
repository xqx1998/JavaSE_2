package com.xqx.A03_ThreadPriority;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 9:20
 * description:
 * 线程调度
 *      两种调度方式
 *          分时调度模型：所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间片
 *          抢占式调度模型：优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一 个，
 *          优先级高的线程获取的 CPU 时间片相对多一些
 *      Java使用的是抢占式调度模型 随机性
 *           假如计算机只有一个 CPU，那么 CPU 在某一个时刻只能执行一条指令，
 *           线程只有得到CPU时间片，也 就是使用权，才可以执行指令。
 *           所以说多线程程序的执行是有随机性，因为谁抢到CPU的使用权是不一 定的
 *
 * 方法名 说明
 * ﬁnal int getPriority() 返回此线程的优先级
 * ﬁnal void setPriority(int newPriority)
 * 更改此线程的优先级 线程默认优先级是5；线程优先级的范围 是：1-10
 */
public class MyThreadDemo{
    public static void main(String[] args) throws InterruptedException {
       /* //2.创建自定线程的对象
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setName("风清扬");
        myThread2.setName("令狐冲");*/

        MyThreadPriority myThread1 = new MyThreadPriority("风清扬");
        MyThreadPriority myThread2 = new MyThreadPriority("令狐冲");
        //设置优先级
        myThread1.setPriority(5);
        myThread2.setPriority(10);
        Thread.currentThread().setPriority(1);

        //设置循环次数
        myThread1.setCount(10);
        // 3.调用start方法启动线程
        myThread1.start();
        myThread2.setCount(50);
        myThread2.start();

        for (int i = 0; i < 100; i++) {
            //获取当前线程名称并打印
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }
}
