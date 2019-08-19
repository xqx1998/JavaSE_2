package homework_day10.extendshomework_01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 19:55
 * description:
 * 练习一:对象的序列化
 * 描述:定义一个学生类，包含姓名，年龄，性别等成员变量，提供setters和getters方法以及构造方法。
 * 在测试类中创建一个学生对象，给学生对象的三个成员变量赋值。然后将该对象保存到当前项目根目录下的stu.txt文件中。
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //定义一个集合,存储Student对象
        List<Student> arr = new ArrayList<>();
        //添加元素
        arr.add(new Student("张三", 20, "男"));
        arr.add(new Student("李四", 22, "男"));
        arr.add(new Student("王五", 23, "男"));
        //创建字节输出流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("day10/stu.txt"));
        // 将集合数据写入到文件中
        objectOutputStream.writeObject(arr);
        // 释放资源
        objectOutputStream.close();
    }
}
