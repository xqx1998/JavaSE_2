package CourseLearn.xqx_6;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        //1、创建流对象
        FileInputStream fis=new FileInputStream("day08/a.txt");
        //2、调用read()方法读数据
        /*int bt = fis.read();
        System.out.println((char)bt);

        bt = fis.read();
        System.out.println((char)bt);

        bt = fis.read();
        System.out.println((char)bt);

        bt = fis.read();
        System.out.println((char)bt);

        bt = fis.read();
        System.out.println((char)bt);

        bt = fis.read(); //读完了会返回-1
        System.out.println(bt);
        bt = fis.read();
        System.out.println(bt);*/

        int bt=0;
        while((bt=fis.read())!=-1){
            System.out.println((char)bt);

        }

        //3、调用close​()释放资源
        fis.close();
    }
}
