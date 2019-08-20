package com.xqx.A02_interface;

/**
 * ### 2.1接口组成更新概述【理解】
 * - 常量
 *   public static final
 * - 抽象方法
 *   public abstract
 * - 默认方法(Java 8)
 * - 静态方法(Java 8)
 * - 私有方法(Java 9)
 *
 *注意：
 *  - 默认方法不是抽象方法，所以不强制被重写。但是可以被重写，重写的时候去掉default关键字
 *  - 静态方法只能通过接口名调用，不能通过实现类名或者对象名调用
 *   - public可以省略，static不能省略
 *
 */

public interface Inter {

    //定义抽象方法
    void abstractMethod();
    //定义默认方法
    default void defaultMethod(){
        privateMethod();
        privateStaticMethod();
    };
    // 定义静态方法
    public static void staticMethod(){
        System.out.println("staticMethod");
        privateStaticMethod();
    }
    // 定义私有方法
    private void privateMethod(){
        System.out.println("privateMethod");
    }
    // 定义私有静态方法
    private static void privateStaticMethod(){
        System.out.println("privateStaticMethod");
    }

}
