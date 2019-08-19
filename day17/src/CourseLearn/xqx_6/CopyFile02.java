package CourseLearn.xqx_6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    需求：将day08/字节输入流--一次读一个字节数组图解.png复制到day08/src/com/itheima_6目录中
    实现思路：
        1、创建输入和输出流对象
        2、一边读一边写，每次读写一个字节数组
        3、释放资源

 */
public class CopyFile02 {
    public static void main(String[] args) throws IOException {
        //1、创建输入和输出流对象
        FileInputStream fis=new FileInputStream("day08/字节输入流--一次读一个字节数组图解.png");
        FileOutputStream fos=new FileOutputStream("day08/src/com/xqx_6/字节输入流--一次读一个字节数组图解.png");

        //2、一边读一边写，每次读写一个字节数组
        byte[] bytes=new byte[1024];
        int len=0;
        while((len=fis.read(bytes))!=-1){
            //写到文件中
            fos.write(bytes,0,len);
        }
        //3、释放资源
        fis.close();
        fos.close();
    }
}
