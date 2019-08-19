package com.xqx.A06_practice.Demo5_producerCustomerMore;

import java.util.Scanner;

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
        //创建生产者实现类对象
        Producer producer = new Producer(box);
        //创建消费者实现类对象
        Customer customer = new Customer(box);
       /* //创建线程，将实现类对象交给线程
        Thread threadProducer1 = new Thread(producer,"送奶001号");
        Thread threadProducer2 = new Thread(producer,"送奶002号");
        Thread threadProducer3 = new Thread(producer,"送奶003号");
        Thread threadCustomerA = new Thread(customer,"A");
        Thread threadCustomerB = new Thread(customer,"B");
        //
        threadProducer1.start();
        threadProducer2.start();
        threadProducer3.start();
        threadCustomerA.start();
        threadCustomerB.start();*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入送奶工人数量：");
        int producers = scanner.nextInt();
        System.out.println("请输入顾客数量：");
        int customers = scanner.nextInt();
        System.out.println("请输入奶箱存放次数");
        box.setTotalMilk(scanner.nextInt());

        for (int i = 0; i < producers; i++) {
            new Thread(producer,"00"+(i+1)).start();
        }

        for (int i = 0; i < customers; i++) {
            new Thread(customer,new String((char)(i+65)+"")).start();
        }


    }
}
