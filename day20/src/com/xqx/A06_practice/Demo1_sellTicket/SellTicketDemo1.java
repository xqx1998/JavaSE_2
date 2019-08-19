package com.xqx.A06_practice.Demo1_sellTicket;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 14:12
 * description:
 * 案例需求 某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
 */
public class SellTicketDemo1 {
    public static void main(String[] args) {

        // 创建任务对象
        SellTicketRunnable sellTicket = new SellTicketRunnable();
        //设置票数
        sellTicket.setTickets(100);
        //创建3个线程对象
        // Thread thread1 = new Thread(sellTicket, "窗口1");
        // Thread thread2 = new Thread(sellTicket, "窗口2");
        // Thread thread3 = new Thread(sellTicket, "窗口3");
        for (int i = 1; i < 11; i++) {
            new Thread(sellTicket,"窗口"+i).start();
        }

        //启动线程
        // thread1.start();
        // thread2.start();
        // thread3.start();
    }
}
