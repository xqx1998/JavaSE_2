package homework_day10.extendshomework_03;

import java.io.*;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 19:55
 * description:
 * 练习三:字节打印流的使用
 * 描述:从键盘录入一行字符串，利用字节打印流将该行字符串保存到当前项目根目录下的d.txt文件中
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //创建字符输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        // 读取键盘输入的字符串
        line = bufferedReader.readLine();

        System.out.println(line);

        //创建字节打印流
        PrintStream printStream = new PrintStream(new FileOutputStream("day19//d.txt"),true);
        //将字符串打印到文件
        printStream.print(line);
        //释放资源
        printStream.close();


    }
}
