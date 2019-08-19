package com.xqx.A06_practice.Demo4_producerCustomer;

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

    public int getMilkNumber() {
        return milkNumber;
    }

    public void setMilkNumber(int milkNumber) {
        this.milkNumber = milkNumber;
    }

    public boolean isState() {
        return state;
    }

    public void setState(final boolean state) {
        this.state = state;
    }
}
