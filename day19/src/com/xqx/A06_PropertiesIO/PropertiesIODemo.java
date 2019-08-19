package com.xqx.A06_PropertiesIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 16:46
 * description:
 *Properties和IO流相结合的方法【应用
 * void load(InputStream inStream)
 * 从输入字节流读取属性列表（键和元素对）
 * void load(Reader reader) 从输入字符流读取属性列表（键和元素对）
 * void store(OutputStream out, String comments)
 * 将此属性列表（键和元素对）写入此 Properties表中，以适合于使用 load(InputStream)方法的格式写入输出字节流
 * void store(Writer writer, String comments)
 * 将此属性列表（键和元素对）写入此 Properties表中，以适合使用 load(Reader)方法的格式写入输出字符流
 */
public class PropertiesIODemo {
    public static void main(String[] args) throws IOException {
        //集合到文件
        mystore();
        //加载文件数据到集合
        Properties properties = myload();
        //答应输出集合
        System.out.println(properties);

    }
    // 集合到文件
    private static void mystore() throws IOException {
        //创建字符输出流对象
        FileWriter fileWriter = new FileWriter("day19//src//db.properties");
        //创建properties集合对象
        Properties properties = new Properties();
        properties.setProperty("url", "mysql://locahost:3306/test");
        properties.setProperty("username", "xqx");
        properties.setProperty("password", "1998");
        //将数据写到文件中
        properties.store(fileWriter,null);
        fileWriter.close();
    }
    //文件到集合
    private static Properties myload() throws IOException {
        // 创建字符输入流对象
        FileReader fileReader = new FileReader("day19//src//db.properties");
        // 创建properties集合对象
        Properties properties = new Properties();
        // 加载文件数据到集合中
        properties.load(fileReader);
        // 释放资源
        fileReader.close();
        // 返回集合对象
        return properties;
    }


}
