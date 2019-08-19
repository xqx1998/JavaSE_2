package CourseLearn.xqx_4;

import java.io.File;

/*
    需求：给定一个目录，找这个目录中的所有文件，如果目录中有子目录，那还要找出子目录中的文件
    分析：定义一个方法，打印给定目录中所有文件的绝对路径，包含子目录中的所有文件绝对路径。
        1、获取该目录中的所有子文件或者子目录  listFiles()
        2、遍历数组，判断是文件还是目录
        3、如果是文件，打印文件的绝对路径。
        4、如果是目录：重复1，2，3，4步， 需要递归调用
 */
public class DiGuiDemo2 {

    public static void main(String[] args) {
        File file=new File("/Users/zhouxiangyang/Desktop/work/2019教研部工作");
        //调用方法
        findAllPath(file);
    }
     public static void findAllPath(File file){
         System.out.println("目录："+file.getAbsolutePath());
        //1、获取该目录中的所有子文件或者子目录  listFiles()
         File[] files = file.listFiles();
         //2、遍历数组，判断是文件还是目录
         for (File f : files) {
             if(f.isFile()){
                 //3、如果是文件，打印文件的绝对路径。
                 System.out.println("文件："+f.getAbsolutePath());
             }else{
                 //4、如果是目录：重复1，2，3，4步， 需要递归调用
                 findAllPath(f);
             }
         }
     }
}
