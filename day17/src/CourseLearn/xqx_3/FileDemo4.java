package CourseLearn.xqx_3;

import java.io.File;

public class FileDemo4 {
    public static void main(String[] args) {
        //需求：删除 day08晚自习 目录，有内容
        File file=new File("day17//src//day08晚自习");
        //获取day08晚自习目录中的所有子文件/目录file对象
        /*File[] files = file.listFiles();
        //遍历所有的子文件，删除子文件/目录
        for (File f : files) {
            f.delete();
        }
        //最后删除day08晚自习目录
        file.delete();*/
        deleteAll(file);
    }

    //递归删除
    public static void deleteAll(File file){
        File[] files = file.listFiles();

        for (File file1 : files) {
            if(file1.isFile()) {
                System.out.println(file1.getAbsolutePath());
                file1.delete();
            }else {
                System.out.println(file1.getAbsolutePath());
                deleteAll(file1);
            }
        }

        if (file.listFiles().length==0) {
            System.out.println(file.getAbsolutePath());
            file.delete();
        }

    }
}
