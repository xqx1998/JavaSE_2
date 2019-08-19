package CourseLearn.xqx_2;

import java.io.File;
import java.io.IOException;

/*
    路径的写法：
        绝对路径：以盘符开头的路径就是绝对路径 例如：C:/aaa/bbb/abc.txt  d:/aaa/bbb/abc.txt
        相对路径：路径不带盘符。相对的是project，module在project中。也就是说默认从project中根据相对路径查找。
                相对路径是以./或者../开头，但是./可以省略不写。./表示当前目录, ../表示上一级目录
                例如：
                ./day08/abc.txt 也可以简写成 day08/abc.txt
                ../abc.txt 表示project的上一级目录下有个abc.txt
 */
public class FileDemo3 {
    public static void main(String[] args) throws IOException {

        File f1=new File("./day17/abc.txt");
        f1.createNewFile();

        File f2=new File("day17/aaa.txt");
        f2.createNewFile();
        // ../ 返回上一级
        File f3=new File("../bcd.txt");  //当前路径为 G:\DarkHorseCode\JavaSE_2 返回上一级为 G:\DarkHorseCode
        f3.createNewFile();

    }
}
