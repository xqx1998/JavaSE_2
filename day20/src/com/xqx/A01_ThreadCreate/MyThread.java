package com.xqx.A01_ThreadCreate;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 9:36
 * description:
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
