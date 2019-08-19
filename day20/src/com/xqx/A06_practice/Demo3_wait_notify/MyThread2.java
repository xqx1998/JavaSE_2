package com.xqx.A06_practice.Demo3_wait_notify;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 16:55
 * description:
 */
public class MyThread2 extends Thread{
    private Object object;

    public MyThread2(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println(getName()+":"+i);
            }
        }
    }
}
