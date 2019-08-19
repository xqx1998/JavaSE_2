package CourseLearn.xqx_6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    实现思路：
     1、创建输入流和输出流对象
     2、一边读一边写，一次读写一个字节
     3、释放资源
 */
public class CopyFile01 {
    public static void main(String[] args) throws IOException {
        //1、创建输入流和输出流对象
        FileInputStream fis=new FileInputStream("day08/a.txt");
        FileOutputStream fos=new FileOutputStream("day08/src/com/xqx_6/b.txt");
        //2、一边读一边写，一次读写一个字节
        int bt=0;
        while((bt=fis.read())!=-1){
            //读一个字节就往b.txt中写一个字节
            fos.write(bt);
        }
        //3、释放资源
        fis.close();
        fos.close();
    }
}
