package com.xqx.A06_practice.Demo4_producerCustomer;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 18:25
 * description:
 * 消费者线程
 */
public class Customer implements Runnable  {
    private Box box;

    public Customer(final Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        // 一直从奶箱中取牛奶
        while (true){
            //同步代码块
            synchronized (box) {
                try {
                    //判断奶箱状态是否为空  为空：则等待
                    if (!box.isState()) {
                        box.wait();
                        //模拟取牛奶时间
                        Thread.sleep(20);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 取牛奶
                int milkNumber = box.getMilkNumber();
                // 设置奶箱状态为空
                box.setState(false);
                // 打印结果
                System.out.println("顾客从奶箱中取了第"+milkNumber+"瓶牛奶，真香");
                // 唤醒消费者线程
                box.notify();
            }

        }
    }
}
