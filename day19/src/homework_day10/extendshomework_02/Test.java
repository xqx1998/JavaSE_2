package homework_day10.extendshomework_02;

import homework_day10.extendshomework_01.Student;

import java.io.*;
import java.util.List;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 19:55
 * description:
 练习二:对象的反序列化
 描述:将上一题保存到stu.txt文件中的学生对象读取出来。
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try(//创建字节输入流对象
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("day10//stu.txt"));) {
            //从文件中读取数据  student对象反序列化
            List<Student> o = (List<Student>) objectInputStream.readObject();
            //遍历集合
            for (Student student : o) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
