package com.xqx.A02_interface;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 14:23
 * description:
 */
public class InterDemo {
    public static void main(String[] args) {
        Inter inter = new InterImpl();
        //抽象方法调用
        inter.abstractMethod();
        System.out.println("------------");
        //接口默认方法调用
        inter.defaultMethod();
        System.out.println("------------");
        //接口静态方法调用
        Inter.staticMethod();
        System.out.println("------------");
    }
}
