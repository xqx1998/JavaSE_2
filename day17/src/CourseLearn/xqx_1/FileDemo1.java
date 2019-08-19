package CourseLearn.xqx_1;

import java.io.File;

/*
    File(String pathname)：通过将给定的路径名字符串创建File对象。
    File(String parent, String child)：从父路径名字符串和子路径名字符串创建新的 File对象，一般parent表示父目录，child表示子文件或者目录。
    File(File parent, String child)：从父抽象路径名和子路径名字符串创建新的 File实例。
 */
public class FileDemo1 {
    public static void main(String[] args) {
        //File(String pathname)：通过将给定的路径名字符串创建File对象。
        File f1=new File("/Users/zhouxiangyang/Desktop/java.txt");
        System.out.println(f1);
        System.out.println(f1.length());
        System.out.println(f1.getName());
    }
}
