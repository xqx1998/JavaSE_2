package com.xqx.A06_practice.Demo4_producerCustomer;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 18:25
 * description:
 * 生产者线程
 */
public class Producer implements Runnable {
    private Box box;

    public Producer(final Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        // 往奶箱中放牛奶
        for (int i = 1; i <= 60; i++) {
            synchronized (box) {
                // 模拟放牛奶需要时间
                try {
                    //判断奶箱是否有牛奶 有：则等待
                    if (box.isState()){
                        box.wait();
                    }
                    //模拟存放牛奶时间
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 设置箱子中牛奶的数量
                box.setMilkNumber(i);
                // 设置箱子状态不为空
                box.setState(true);
                // 打印放了第几瓶牛奶
                System.out.println(Thread.currentThread().getName()+"  工人往奶箱中放了第"+i+"瓶牛奶，真累");
                //唤醒顾客线程
                box.notifyAll();
            }
        }
    }
}
