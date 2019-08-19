package homework_day10.extendshomework_05;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 20:53
 * description:
 * 练习五:对象的序列化,对象输出流的使用
 * 描述:
 * 定义一个学生类，成员变量有姓名，年龄，性别，提供setters和getters方法以及构造方法
 * 定义一个测试类，使用序列化流向文件中保存多名学生信息，并使用反序列化流将多名学生信息读取打印到控制台。
 */
public class Test {
    private static final String path = "day19//src//homework_day10//extendshomework_05//student05.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("请选择：1.添加学生信息 2.查看学生信息 3.退出");
            System.out.println("请输入指令");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.equals("1")) {
                setStudent(getStudent());
            }else if (choice.equals("2")) {
                ArrayList<Student> students1 = getStudent();
                if (students1 != null)
                    for (Student student : students1) {
                        System.out.println(student);
                    }
                else
                    System.out.println("暂无学生信息");
            }else if(choice.equals("3")){
                break;
            }
        }

    }

    /**
     * 从文件中获取学生信息
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Student> getStudent() throws IOException, ClassNotFoundException {
        ArrayList<Student> students = null;
        ObjectInputStream objectInputStream = null;
        //注意：万一数据文件没有数据时，反序列化就会报错 EOFException，解决办法 try... catch
        try {
            //反序列化学生对象
            objectInputStream = new ObjectInputStream(new FileInputStream(path));

            students = (ArrayList<Student>) objectInputStream.readObject();
        } catch (EOFException e) {

        }
        //释放资源
        if (objectInputStream != null)
            objectInputStream.close();
        //返回集合
        return students;
    }

    /**
     * 更新学生信息到文件
     * @param students  学生信息集合
     * @throws IOException
     */
    public static void setStudent(ArrayList<Student> students) throws IOException {
        if(students == null){
            students = new ArrayList<>();
        }
        //反序列化学生对象
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        while (true) {
            System.out.println("请输入学生信息：");
            System.out.println("姓名：");
            student.setName(scanner.next());
            System.out.println("年龄：");
            student.setAge(scanner.nextInt());
            System.out.println("性别：");
            student.setSex(scanner.next());
            students.add(student);
            System.out.println("继续录入请按1，结束录入请按0");
            String choice = scanner.next();
            if ("0".equals(choice)) {
                break;
            }
        }
        //创建输出流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        //将集合数据写到文件中
        objectOutputStream.writeObject(students);
        //释放资源
        objectOutputStream.close();
    }
}
