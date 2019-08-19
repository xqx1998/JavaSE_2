package homework_day20.homework_07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/16 21:36
 * description:练习七：多线程练习
 * 问题：
 * 	请按要求编写多线程应用程序，模拟多个人通过一个山洞：
 * 		1.这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒；
 * 2.循环生成10个人，同时准备过此山洞，并且定义一个变量用于记录通过隧道的人数。显示每次通过山洞人的姓名，和通过顺序
 */
public class Test {
    private static Object object = new Object();
    static int count = 1;
    public static void main(String[] args) {
        //定义字符输入流对象
        BufferedReader bufferedReader = null;
        //创建集合存储姓名
        ArrayList<String> names = new ArrayList<>();
        //读取姓名文件数据
        try {
            //创建字符输入流
            bufferedReader = new BufferedReader(new FileReader("day20\\src\\homework_day20\\homework_07\\name.txt"));
            //判读 读取
            while (bufferedReader.ready()) {
                names.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if (bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //循环生成10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //同步代码
                    synchronized (object) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("第"+(count++)+"位通过山洞:是 "+Thread.currentThread().getName());
                    }
                }
            },names.get(i)+i).start();
        }
    }
}
