package com.xqx.A06_practice.Demo5_producerCustomerMore;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 18:26
 * description:
 * 共享数据对象
 */
public class Box {
    //定义变量 记录第几瓶牛奶
    private int milkNumber;
    private boolean state; //记录奶箱是否为空 true：有奶 false：无奶
    private int totalMilk; //记录奶箱存放总次数
    private PrintWriter bu;
    private BufferedReader br;

    {
        try {
            bu = new PrintWriter(new FileWriter("day20\\src\\com\\xqx\\A06_practice\\Demo5_producerCustomerMore\\log.txt", true), true);
            br = new BufferedReader(new FileReader("day20\\src\\com\\xqx\\A06_practice\\Demo5_producerCustomerMore\\log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getTotalMilk() {
        return totalMilk;
    }

    public void setTotalMilk(final int totalMilk) {
        this.totalMilk = totalMilk;
    }

    /**
     * 同步方法 取牛奶
     */
    public synchronized void getMilkNumber() {
        if (milkNumber < totalMilk) {
            if (!isState()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
           /* try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            if (isState()) {
                System.out.println(Thread.currentThread().getName() + "顾客从奶箱中取了第" + milkNumber + "瓶牛奶，真香");
                bu.println(Thread.currentThread().getName());
                setState(false);
            }
            notifyAll();
        } else {
            System.out.println(totalMilk + "次存放拿取已完成，欢迎下次合作");
            if (bu != null)
                bu.close();
            try {
                logDeal(br);
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

    /**
     * 同步方法 放牛奶
     */
    public synchronized void setMilkNumber() {
        if (milkNumber < (totalMilk - 1)) {
            //判断奶箱是否有奶  有：则等待
            if (isState()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            /*try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            if (!isState()) {
                milkNumber++;
                setState(true);
                System.out.println(Thread.currentThread().getName() + "工人往奶箱中放了第" + milkNumber + "瓶牛奶，真累");
                bu.println(Thread.currentThread().getName());
            }
            notifyAll();
        }
    }

    public boolean isState() {
        return state;
    }

    public void setState(final boolean state) {
        this.state = state;
    }

    public void logDeal(BufferedReader br) throws IOException {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        while (br.ready()){
            String str = br.readLine();
            if (!map.containsKey(str))
                map.put(str,1);
            else {
                int value = map.get(str);
                value++;
                map.put(str, value);
            }
        }
        Set<String> keySet = map.keySet();
        keySet.forEach(key-> System.out.println(key+": "+map.get(key)+"次"));
    }
}
