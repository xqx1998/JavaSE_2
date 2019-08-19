package com.xqx.A06_practice.Demo5_producerCustomerMore;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 18:25
 * description:
 * 生产者线程
 */
public class Producer implements Runnable {
    private Object object =  new Object();
    private Box box;

    public Producer(final Box box) {
        this.box = box;
    }

    @Override
    public void run() {
            while (true)
                // 设置箱子中牛奶的数量
                box.setMilkNumber();
    }
}
