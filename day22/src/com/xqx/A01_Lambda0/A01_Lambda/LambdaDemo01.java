package com.xqx.A01_Lambda0.A01_Lambda;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 9:16
 * description:
 * 需求：启动一个线程，在控制台打印：多线程启动了
 */
public class LambdaDemo01 {
    public static void main(String[] args) {
        //实现类启动
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        //匿名内部类的方式启动 --- 简化了实现类类和子类的书写
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类启动了多线程");
            }
        }).start();


        // Lambda表达式的方式 --- 简化了匿名内部类的书写
        new Thread(()->{
            System.out.println("Lambda启动了多线程");
        }).start();
    }
}
