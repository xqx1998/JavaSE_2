package com.xqx.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 18:18
 * description:
 * 案例需求
 *      实现猜数字小游戏只能试玩3次，如果还想玩，提示：游戏试玩已结束，想玩请充值(www.itcast.cn)
 * 分析步骤
 *  1. 写一个游戏类，里面有一个猜数字的小游戏
 *  2. 写一个测试类，测试类中有main()方法，main()方法中写如下代码：
 *          从文件中读取数据到Properties集合，用load()方法实现
 *          文件已经存在：game.txt
 *          里面有一个数据值：count=0
 *          通过Properties集合获取到玩游戏的次数
 *          判断次数是否到到3次了 如果到了，给出提示：游戏试玩已结束，想玩请充值(www.itcast.cn)
 *          如果不到3次：
 *          次数+1，重新写回文件，用Properties的store()方法实现玩游戏
 */
public class Test {
    private static final String path = "day19//src//com//xqx//practice//count.properties";
    public static void main(String[] args) throws IOException {
        int count = getCount();
        if (count<3) {
            System.out.println("本次之后还有"+(3-(++count))+"次试玩机会");
            playGame();
            setCount(count);
        }else{
            System.out.println("充钱");
        }
    }
    private static void playGame() {
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入1~100之间的整数：");
            int guessNum = scanner.nextInt();
            // System.out.println(num);
            if (num > guessNum){
                System.out.println("猜小了");
            }else if(num<guessNum) {
                System.out.println("猜大了");
            }else{
                System.out.println("恭喜你，猜中了");
                break;
            }
        }
    }

    /**
     * 从配置文件中获取游戏次数
     * @return
     * @throws IOException
     */
    private static int getCount() throws IOException {
        //创建字符输入流对象
        FileReader fileReader = new FileReader(path);
        //创建集合
        Properties properties = new Properties();
        //从将配置文件中的数据加载到集合中
        properties.load(fileReader);
        //获取游戏次数
        int count = Integer.valueOf(properties.getProperty("count"));
        //释放资源
        fileReader.close();
        //返回次数
        return count;
    }

    /**
     * 在配置文件中写入游戏次数
     * @param count
     * @throws IOException
     */
    private static void setCount(int count) throws IOException {
        //创建字符输出流对象
        FileWriter fileWriter = new FileWriter(path);
        // 创建集合
        Properties properties = new Properties();
        // 给集合添加键值对
        properties.setProperty("count",count+"");
        // 将集合数据写到配置文件中
        properties.store(fileWriter,null);
        //释放资源
        fileWriter.close();
    }
}
