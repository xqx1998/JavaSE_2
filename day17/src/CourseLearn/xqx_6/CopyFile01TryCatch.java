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
public class CopyFile01TryCatch {
    public static void main(String[] args) {
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            //1、创建输入流和输出流对象
            fis = new FileInputStream("day08/a.txt");
            fos = new FileOutputStream("day08/src/com/xqx_6/b.txt");
            //2、一边读一边写，一次读写一个字节
            int bt=0;
            while((bt=fis.read())!=-1){
                //读一个字节就往b.txt中写一个字节
                fos.write(bt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3、释放资源
            if (fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
