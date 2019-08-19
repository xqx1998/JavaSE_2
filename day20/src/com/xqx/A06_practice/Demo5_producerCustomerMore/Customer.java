package com.xqx.A06_practice.Demo5_producerCustomerMore;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 18:25
 * description:
 * 消费者线程
 */
public class Customer implements Runnable {
    private Box box;

    public Customer(final Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        // 一直从奶箱中取牛奶
        while (true) {
            // 取牛奶
            box.getMilkNumber();
        }
    }
}
