package com.xqx.A04_Practice.Demo02;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/19 16:46
 * description:
 * - 范例
 *    "HelloWorld"::toUpperCase
 *      String类中的方法：public String toUpperCase() 将此String所有字符转换为大写
 * - 练习描述
 *   - 定义一个类(PrintString)，里面定义一个方法
 *     public void printUpper(String s)：把字符串参数变成大写的数据，然后在控制台输出
 *   - 定义一个接口(Printer)，里面定义一个抽象方法
 *     void printUpperCase(String s)
 *   - 定义一个测试类(PrinterDemo)，在测试类中提供两个方法
 *     - 一个方法是：usePrinter(Printer p)
 *     - 一个方法是主方法，在主方法中调用usePrinter方法
 */
public class PrinterDemo {
    public static void main(String[] args) {

        //Lambda简化写法
        usePrinter(s -> System.out.println(s.toUpperCase()));

        //引用对象的实例方法
        PrintString ps = new PrintString();
        usePrinter(ps::printUpper);

    }

    private static void usePrinter(Printer p) {
        p.printUpperCase("HelloWorld");
    }
}
