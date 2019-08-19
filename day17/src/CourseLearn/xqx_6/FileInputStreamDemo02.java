package CourseLearn.xqx_6;

import java.io.FileInputStream;
import java.io.IOException;

/*
    int	read​(byte[] b)	：一次读一个字节数组(常用)
    int	read​(byte[] b, int off, int len)：一次读一个字节数组的一部分
 */
public class FileInputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        //1、创建流对象
        FileInputStream fis=new FileInputStream("day08/fos.txt");
        //2、调用read()方法读数据--一次读一个字节数组
        /*
            在开发中byte数组的长度一般为1024或者1024的整数倍。1024个字节=1kb；
         */
        byte[] bytes=new byte[1024];//这个字节数组可以看成是一个容器，每次往这个容器中存数据。
        int len=0;//保存每次读写的个数，如果为-1，表示读完了
        while ((len=fis.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len));
        }

        /*int len=fis.read(bytes);
        System.out.println("len = " + len);
        System.out.println(new String(bytes));


        len=fis.read(bytes);
        System.out.println("len = " + len);
        System.out.println(new String(bytes));

        len=fis.read(bytes);
        System.out.println("len = " + len);
        System.out.println(new String(bytes));

        len=fis.read(bytes);
        System.out.println("len = " + len);
        System.out.println(new String(bytes));

        len=fis.read(bytes);
        System.out.println("len = " + len);
        System.out.println(new String(bytes));*/
        //3、调用close​()释放资源
        fis.close();
    }
}
