package com.xqx.A07_expand;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 19:47
 * description:
 * 线程池技术
 */
public class ExpandDemo02 {
    public static void main(String[] args) {
        //创建容量为5的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //使用for循环创建Runnable任务，交给线程池中的线程执行
        for (int i = 0; i < 100; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        //销毁线程池中所有线程
        threadPool.shutdown();
    }
}
