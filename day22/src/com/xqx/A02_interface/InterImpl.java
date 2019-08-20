package com.xqx.A02_interface;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 14:24
 * description:
 */
public class InterImpl implements  Inter{
    //重写接口抽象方法
    @Override
    public void abstractMethod() {
        System.out.println("abstractMethod");
    }

}
