package com.xqx.A06_practice.Demo1_sellTicket;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 14:14
 * description: 多线程共享数据会出现数据安全问题（线程安全）
 * 解决办法：
 *      同步代码块：
     *      语法格式：
*                 synchronized(任意对象) {
 *                  多条语句操作共享数据的代码
 *                  }
 *          synchronized(任意对象)：就相当于给代码加锁了，任意对象就可以看成是一把锁
 *          同步的好处和弊端
 *              好处：解决了多线程的数据安全问题
 *              弊端：当线程很多时，因为每个线程都会去判断同步上的锁，这是很耗费资源的，无形中会降低程序的 运行效率
 *      同步方法：就是把synchronized关键字加到方法上
 *          语法格式：
 *              修饰符 synchronized 返回值类型 方法名(方法参数){
 *                  方法体；
 *              }
 *          同步方法的锁对象是什么呢? this
 *      静态同步方法：就是把synchronized关键字加到静态方法上
 *          语法格式：
 *              修饰符 static synchronized 返回值类型 方法名(方法参数) {
 *                  方法体；
 *              }
 *          同步静态方法的锁对象是什么呢? 类名.class
 */
public class SellTicketRunnable implements Runnable {
    private Object obj = new Object();
    private static int tickets;

    public SellTicketRunnable() {
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(final int tickets) {
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while (true){
            //同步代码跨
            /*synchronized (obj){
                if(tickets>0){
                    try {
                        //通过sleep方法模拟出票时间
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"张票");
                    tickets--;
                }else{
                    System.exit(0);
                }
            }*/
            // sellTicket();
            synchronized (SellTicketRunnable.class){
                sellTickets();
            }
        }
    }

    public synchronized void sellTicket(){
        if(tickets>0){
            try {
                //通过sleep方法模拟出票时间
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"张票");
            tickets--;
        }else{
            System.exit(0);
        }
    }

    public static synchronized void sellTickets(){
        if(tickets>0){
            try {
                //通过sleep方法模拟出票时间
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"张票");
            tickets--;
        }else{
            System.exit(0);
        }
    }
}
