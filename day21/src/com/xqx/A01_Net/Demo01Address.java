package com.xqx.A01_Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 10:57
 * description:
 * InetAddress
 *         此类表示Internet协议（IP）地址
 *
 *     public static InetAddress getByName​(String host)：确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址
 *     public String getHostName​()：获取此IP地址的主机名
 *     public String getHostAddress​()：返回文本显示中的IP地址字符串
 */
public class Demo01Address {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机IP地址
        InetAddress byAddress = InetAddress.getLocalHost();
        System.out.println("byAddress.getHostName() = " + byAddress.getHostName());
        System.out.println("byAddress = " + byAddress);
        System.out.println("byAddress.getHostAddress() = " + byAddress.getHostAddress());
    }
}
