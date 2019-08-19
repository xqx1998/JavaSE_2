package com.xqx.A02_ThreadName;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 9:36
 * description:
 *
 */
public class MyThreadName extends Thread{

    public MyThreadName() {
    }

    public MyThreadName(final String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}
