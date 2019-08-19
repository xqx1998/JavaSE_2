package com.itheima.domain;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 14:32
 * description:
 * 1.创建钞票类（Money）
 * 		属性：面值、真假(bolean类型)
 */
public class Money {
    private int value;
    private boolean flag;

    public Money() {
    }

    public Money(final int value, final boolean flag) {
        this.value = value;
        this.flag = flag;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(final boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", flag=" + flag +
                '}';
    }
}
