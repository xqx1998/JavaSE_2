package com.xqx.A06_practice.Demo3_wait_notify;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 16:55
 * description:
 */
public class MyThread1 extends Thread{
    private Object object;

    public MyThread1(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            for (int i = 0; i < 100; i++) {
                System.out.println(getName()+":"+i);
            }
            object.notify();
        }
    }
}
