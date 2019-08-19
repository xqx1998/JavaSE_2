package com.xqx.A03_ThreadPriority;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 9:36
 * description:
 *
 */
public class MyThreadPriority extends Thread{
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public MyThreadPriority() {
    }

    public MyThreadPriority(final String name) {
        super(name);
    }

    @Override
    public void run() {
        show();
    }

    public void show(){
        for (int i = 0; i < count; i++) {
            System.out.println(getName()+":"+i);
        }
    }


}
