package com.xqx.A04_ThreadAPI.join;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 9:36
 * description:
 *
 */
public class MyThread extends Thread{
    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public void setThread(final Thread thread) {
        this.thread = thread;
    }

    public MyThread() {
    }

    public MyThread(Thread thread) {
        this.thread = thread;
    }

    public MyThread(final String name) {
        super(name);
    }

    @Override
    public void run() {
        show();
    }

    public void show(){
        if (thread!=null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+":"+i);
        }
    }


}
