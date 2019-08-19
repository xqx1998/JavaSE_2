package com.xqx.A06_practice.Demo4_producerCustomer;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 18:25
 * description:
 * 等待唤醒机制需求：
 *         有一个生产者线程（送奶工线程），需要往奶箱中放牛奶，还有一个消费者线程（顾客线程），需要从奶箱中取牛奶。
 *         问题1：生产者线程和消费者线程都要操作同一个对象奶箱，就可能出现线程安全问题。
 *             解决：同步代码块
 *             需要：同一个锁对象，
 *         问题2：必须要生产者线程先放牛奶，消费者线程才能取牛奶，有一个先后顺序问题。
 *             生产者线程：
 *                 1 判断奶箱中是否有牛奶，如果有牛奶，那么就等待，等消费者线程喝完了之后唤醒
 *                 2、一旦被唤醒之后名，放牛奶
 *                 3、唤醒消费者线程取取牛奶
 *             消费者线程：
 *                 1、判断奶箱中是否有牛奶，如果没有牛奶，那么就等待，等待生产者线程放完牛奶之后唤醒
 *                 2、一旦唤醒之后，取牛奶和牛奶
 *                 3、唤醒生产者线程放牛奶
 */
public class Test {
    public static void main(String[] args) {
        //创建奶箱对象，传递给生产者线程和消费者线程
        Box box = new Box();
        //创建生产者实现类对象
        Producer producer = new Producer(box);
        //创建消费者实现类对象
        Customer customer = new Customer(box);
        //创建生产者线程，将实现类对象交给线程
        Thread threadProducer1 = new Thread(producer);
        //创建消费者线程，将实现类对象交给线程
        Thread threadCustomer = new Thread(customer);
        //启动生产者线程和顾客线程
        threadProducer1.start();
        threadCustomer.start();

    }
}
