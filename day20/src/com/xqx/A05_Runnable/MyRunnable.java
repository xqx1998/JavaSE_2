package com.xqx.A05_Runnable;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 11:56
 * description:
 * 创建一个类实现Runnable接口，重写run方法，run方法中的代码就是线程要执行的代码
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
