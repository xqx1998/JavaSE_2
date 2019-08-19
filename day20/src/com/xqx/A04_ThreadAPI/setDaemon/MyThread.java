package com.xqx.A04_ThreadAPI.setDaemon;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 9:36
 * description:
 *
 */
public class MyThread extends Thread{
    public MyThread() {
    }

    public MyThread(final String name) {
        super(name);
    }

    @Override
    public void run() {
        show();
    }

    public void show(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+":"+i);
        }
    }


}
