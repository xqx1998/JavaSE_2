package com.xqx.A06_practice.Demo4_producerCustomerMethod;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 18:25
 * description:
 * 等待唤醒机制
 */
public class Test {
    public static void main(String[] args) {
        //创建奶箱对象
        Box box = new Box();
        //定义奶箱存放次数
        box.setTotalMilk(60);
        //创建生产者实现类对象
        Producer producer = new Producer(box);
        //创建消费者实现类对象
        Customer customer = new Customer(box);
        //创建线程，将实现类对象交给线程
        Thread threadProducer1 = new Thread(producer,"送奶001号");
        Thread threadProducer2 = new Thread(producer,"送奶002号");
        Thread threadCustomerA = new Thread(customer,"A");
        // Thread threadCustomerB = new Thread(customer,"B");
        //启动线程
        threadProducer1.start();
        threadProducer2.start();
        threadCustomerA.start();
        // threadCustomerB.start();

    }
}
