package com.xqx.A06_practice.Demo4_producerCustomerMethod;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 18:26
 * description:
 * 共享数据对象
 */
public class Box {
    //定义变量 记录第几瓶牛奶
    private  int milkNumber;
    private boolean state;
    private int totalMilk;

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
        if (!isState()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"顾客从奶箱中取了第"+milkNumber+"瓶牛奶，真香");
        setState(false);
        notifyAll();
    }

    /**
     * 同步方法 放牛奶
     */
    public synchronized void setMilkNumber() {
        if(milkNumber<(totalMilk-1)) {
            //判断奶箱是否有奶  有：则等待
            if (isState()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            milkNumber++;
            setState(true);
            System.out.println(Thread.currentThread().getName()+"工人往奶箱中放了第" + milkNumber + "瓶牛奶，真累");
            notifyAll();
        }
    }

    public boolean isState() {
        return state;
    }

    public void setState(final boolean state) {
        this.state = state;
    }
}
