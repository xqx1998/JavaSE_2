package com.itheima.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * createAuthor：倖权祥
 * createTime：2019/8/17 14:00
 * description:
 * 第一题：分析以下需求，并用代码实现（20分）
 * 	1. 从键盘录入一个日期字符串,格式为 xxxx-xx-xx,代表该人的出生日期；
 * 	2. 利用人出生日期到当前日期所经过的毫秒值计算出这个人活了多少天；
 * 	3. 在控制台打印结果以及程序运行所使用的时间。
 * 	例如：
 * 		请按照格式“xxxx-xx-xx”输入出生日期：
 * 		2015-10-20
 * 		此人已经活了1336天
 * 		程序运行总共31毫秒
 */
public class Test01 {
    public static void main(String[] args) {
        //获取当前系统时间毫秒数
        long start = System.currentTimeMillis();
        System.out.println("请按照格式“xxxx-xx-xx”输入出生日期：");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        //创建日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //存储出生日期
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //存储出生时间毫秒数
        long birthTime = parse.getTime();
        //存储当前时间毫秒数
        long currentTime = new Date().getTime();
        //计算时长 天数
        long liveDay = (currentTime-birthTime)/1000/60/60/24;
        //打印输出
        System.out.println("此人已经活了"+liveDay+"天");
        //获取系统当前时间
        long end = System.currentTimeMillis();
        // 计算程序运行时间 并打印
        System.out.println("程序运行总共"+(end-start)+"毫秒");
    }
}
