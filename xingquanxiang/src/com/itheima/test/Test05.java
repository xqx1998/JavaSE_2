package com.itheima.test;

import java.io.*;
import java.util.Scanner;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/17 15:15
 * description:
 * 第五题：分析以下需求，并用代码实现（20分）
 * 模拟歌曲复制和删除过程：假设在D：\\songs文件夹中存在一些歌曲(均为mp3格式)
 * 循环显示该菜单：请选择您要进行的操作：1：查询所有歌曲   2：根据歌曲名称复制  3：根据歌曲名称删除 4: 退出
 * 举例：
 * 用户输入：1
 * 存在以下歌曲：
 * 蒙娜丽莎的眼泪
 * 烟花易冷
 * 上海滩
 * 小苹果
 * 夜空中最亮的星
 * <p>
 * 用户输入：2
 * 请输入要复制的歌曲名称: 上海滩
 * 请输入存储路径: E:\\songs  (说明:该路径如果存在则不创建,不存在则创建)
 * 复制结果: 歌曲上海滩已经成功复制到E:\\songs目录中
 * <p>
 * 用户输入：3
 * 请输入要删除的歌曲名称: 上海滩
 * 删除结果: 歌曲上海滩已经成功删除
 * <p>
 * 用户输入: 4
 * 退出系统
 */
public class Test05 {
    static final String songsPath = "xingquanxiang//songs";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请选择您要进行的操作：1：查询所有歌曲   2：根据歌曲名称复制  3：根据歌曲名称删除 4: 退出");
            System.out.print("用户输入：");
            switch (scanner.next()) {
                case "1":
                    findAll();
                    break;
                case "2":
                    System.out.print("请输入要复制的歌曲名称：");
                    String name = scanner.next();
                    System.out.print("请输入存储路径:");
                    String path = scanner.next();
                    copy(name, path);
                    break;
                case "3":
                    System.out.print("请输入要删除的歌曲名称：");
                    delete(scanner.next());
                    break;
                case "4":
                    return;
                default:
                    System.out.println("指令输入有误！");
            }
        }
    }

    private static void findAll() {
        System.out.println("存在以下歌曲：");
        File folder = new File(songsPath);
        for (File file : folder.listFiles()) {
            String name = file.getName();
            name = name.substring(0, name.indexOf('.'));
            System.out.println(name);
        }
    }

    /**
     * TODO 待完善
     *
     * @param name
     * @param path
     * @throws FileNotFoundException
     */
    private static void copy(String name, String path) {
        //创建目的目录
        File destFolder = new File(path);
        try (//创建字节输入流 读文件
             BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(find(name).toString()));
             //创建字节输出流 写文件
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(path, find(name).getName())));) {
            //创建缓冲流数组
            byte[] bytes = new byte[8192];
            int len = 0;
            //复制  一边读一边写
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (new File(path, find(name).getName()).exists())
            System.out.println("复制结果: 歌曲上海滩已经成功复制到" + path + "目录中");
    }

    private static void delete(String name) {
        File file = new File(songsPath + "//" + name + ".mp3");
        if (file.exists()) {
            file.delete();
            System.out.println("删除结果: " + name + "已经成功删除");
        } else {
            System.out.println("歌曲不存在！");
        }
    }

    private static File find(String name) {
        File file = new File(songsPath + "//" + name + ".mp3");
        if (!file.exists())
            System.out.println("歌曲不存在！");
        return file;
    }
}
