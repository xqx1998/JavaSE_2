package com.xqx.A04_PrintStream;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 14:23
 * description:
 * 打印流分类
 *      字节打印流：PrintStream
 *      字符打印流：PrintWriter
 * 打印流的特点
 *      只负责输出数据，不负责读取数据
 *      永远不会抛出IOException
 *      有自己的特有方法
 * 字节打印流
 *      PrintStream(String ﬁleName)：使用指定的文件名创建新的打印流
 *      使用继承父类的方法写数据，查看的时候会转码；
 *      使用自己的特有方法写数据，查看的数据原样输出
 *      可以改变输出语句的目的地
 *      public static void setOut(PrintStream out)：重新分配“标准”输出流
 */
public class PrintStreamDemo {
    public static void main(String[] args) {
        
    }

}
