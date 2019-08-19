package homework_day10.extendshomework_04;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 19:55
 * description:
 * 练习四:高效字符流读写数据
 * 描述:
 * 项目根路径下有text.txt文件，内容如下：
 * 	我爱黑马
 * 	123456
 * 利用IO流的知识读取text.txt文件的内容反转后写入text1.txt文件中，内容如下：
 * 	123456
 * 我爱黑马
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //创建路径
        String path = "day19//src//homework_day10//extendshomework_04//text.txt";
        String path1 = "day19//text1.txt";
        //创建高效字符流
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        //创建集合存储文件数据
        ArrayList<String> list = new ArrayList<>();

        String line = null;
        //从文件读取每一行数据
        while ((line=bufferedReader.readLine())!=null){
            list.add(line);
        }

        //创建字符打印流
        PrintWriter printWriter = new PrintWriter(new FileWriter(path1),true);
        //反转集合
        Collections.reverse(list);
        //遍历打印到文件
        for (String s : list) {
            printWriter.println(s);
        }
    }
}
