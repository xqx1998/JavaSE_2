package CourseLearn.xqx_5;

import java.io.FileOutputStream;
import java.io.IOException;
/*
    问题1：写数据换行，向文件中写一个换行符
         mac：\r
         linux: \n
         windows: \r\n
         现在都不区分系统了，随便使用哪个都可以

    问题2：文件数据追加
        FileOutputStream​(String name, boolean append)构造方法的第二个参数传递true，表示文件追加
 */
public class FileOutputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        //1、创建流对象
//        FileOutputStream fos=new FileOutputStream("day08/fos.txt");
        FileOutputStream fos=new FileOutputStream("day08/fos.txt",true);
        //2、调用write方法写数据
        for (int i = 0; i < 10; i++) {
            fos.write("杨锌怒是这条街最靓的仔\r\n".getBytes());
        }
        //3、释放资源
        fos.close();
    }
}
