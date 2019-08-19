package com.xqx.A07_expand;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 19:39
 * description:
 * 使用匿名内部类的形式创建线程对象并启动线程
 *
 */
public class ExpandDemo01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            //方式1：Thread匿名子类对象
            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 50; i++) {
                        System.out.println(getName()+":"+i);
                    }
                }
            }.start();
        }

        // 方式2：实现Runnable接口的方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }).start();
    }
}
