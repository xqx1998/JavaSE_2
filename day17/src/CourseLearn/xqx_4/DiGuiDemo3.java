package CourseLearn.xqx_4;

import java.io.File;

/*
    需求：给定一个目录（有内容），递归删除该目录
    分析：定义一个方法，删除给定的目录。
        1、获取该目录中的所有子文件或者子目录  listFiles()
        2、遍历数组，判断是文件还是目录
        3、如果是文件，删除该文件。
        4、如果是目录：重复1，2，3，4步， 需要递归调用
        5、删除该空目录
 */
public class DiGuiDemo3 {

    public static void main(String[] args) {
        File file=new File("day08/abc");
        //调用方法
        delete(file);
    }
     public static void delete(File file){
         System.out.println("目录："+file.getAbsolutePath());
         //1、获取该目录中的所有子文件或者子目录  listFiles()
         File[] files = file.listFiles();
         //2、遍历数组，判断是文件还是目录
         for (File f : files) {
             if(f.isFile()){
                 //3、如果是文件，删除该文件。。
                 f.delete();
             }else{
                 //4、如果是目录：重复1，2，3，4步， 需要递归调用
                 delete(f);
             }
         }
         //5、删除该空目录
        file.delete();
     }
}
