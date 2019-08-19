package homework_day10.extendshomework_06;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 21:51
 * description:
 * 练习六:IO对象Properties结合使用,设置properties文件
 * 描述:
 * 我有一个属性文件score.properties,请写一个程序判断是否有"lisi"这样的键存在，如果有就改变其实为"100"
 * score.properties文件内容如下：
 * zhangsan = 90
 * lisi = 80
 * wangwu = 85
 */
public class Test {
    static final String path = "day19//src//homework_day10//extendshomework_06//score.properties";
    public static void main(String[] args) throws IOException {
        System.out.println("原数据:");
        //从属性文件获取数据
        Properties properties = getData();
        Scanner scanner = new Scanner(System.in);
        //遍历
       /* for (final String s : properties.stringPropertyNames()) {
            System.out.println(s+"="+properties.getProperty(s));
            //判断 修改
            if (s.equals("lisi")) {
                System.out.println("修改lisi值:");
                properties.setProperty(s, scanner.next());
            }
        }*/
        System.out.println("请输入要修改值的键：");
        String key = scanner.next();
       if(properties.containsKey(key)){
           System.out.println("请输入值：");
           properties.setProperty(key, scanner.next());
       }else{
           System.out.println("不存在"+key);
       }
        //更新数到属性文件
        setData(properties);
        //从属性文件获取数据
        properties = getData();
        //遍历
        System.out.println("更新后");
        for (final String s : properties.stringPropertyNames()) {
            System.out.println(s+"="+properties.getProperty(s));
        }
    }

    //从文件获取数据
    public static Properties  getData() throws IOException {
        //创建集合对象
        Properties properties = new Properties();
        //创建字符输入流
        FileReader fileReader = new FileReader(path);
        //加载文件数据到集合中
        properties.load(fileReader);
        //释放资源
        fileReader.close();
        //返回集合
        return properties;
    }
    //更新文件内部数据
    public static void setData(Properties properties) throws IOException {
        //创建字符输出流
        FileWriter fileWriter = new FileWriter(path);
        //将集合中的数据写入到文件中
        properties.store(fileWriter,null);
        //释放资源
        fileWriter.close();
    }
}
