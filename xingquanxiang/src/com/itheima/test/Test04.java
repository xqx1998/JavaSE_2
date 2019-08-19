package com.itheima.test;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 14:54
 * description:
 * 第四题：分析以下需求，并用代码实现（20分）
 * 同时开启两个线程，共同输出1-100之间的所有数字，并且将输出奇数的线程名称打印出来
 */
public class Test04 {
    static Object object = new Object();
    static int count = 1;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            //创建线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (count < 10000) {
                        synchronized (object) {
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (count % 2 == 1) {
                                System.out.println(count + "：奇数，输出线程：" + Thread.currentThread().getName());
                            } else {
                                System.out.println(count/*+":"+Thread.currentThread().getName()*/);
                            }
                            count++;
                        }
                    }
                }
            }).start();
        }
    }
}
