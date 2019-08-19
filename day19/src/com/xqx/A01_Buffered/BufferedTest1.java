package com.xqx.A01_Buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 9:27
 * description:
 * 对集合中的Student对象进行排序，排序完成之后写到文件夹中，格式：张三,90,80
 * 排序：先按总分降序排序，总分一样，按照语文降序，语文一样，按照姓名升序
 *
 */
public class BufferedTest1 {
    public static void main(String[] args) throws IOException {
        //定义TreeSet集合，定义排序规则，存储到student对象
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o2.getTotal()-o1.getTotal();
                int result1 = result==0?o2.getChinese()-o1.getChinese():result;
                int result2 = result1==0?o1.getName().compareTo(o2.getName()):result1;
                return result2;
            }
        });

        // 创建Student对象，存储到集合中
        Student s1 = new Student("风清扬", 90, 98);
        Student s2 = new Student("令狐冲", 98, 90);
        Student s3 = new Student("任盈盈", 97, 90);
        Student s4 = new Student("人天行", 90, 90);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);


        // 定义字符缓冲流输出对象
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("day19//src//com//xqx//A01_Buffered//student.xlsx"));
        for (Student student : students) {
            System.out.println(student);
            //写入数据
            bufferedWriter.write(student.toString());
            //写换行
            bufferedWriter.newLine();
            //刷新缓冲区
            bufferedWriter.flush();
        }
        //释放资源
        bufferedWriter.close();

    }
}
