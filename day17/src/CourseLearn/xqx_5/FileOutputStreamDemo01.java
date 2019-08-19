package CourseLearn.xqx_5;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        //1、创建流对象
        FileOutputStream fos=new FileOutputStream("day08/fos.txt");
        //2、调用write方法写数据
        for (int i = 0; i < 10; i++) {
            fos.write("杨锌怒是这条街最靓的仔".getBytes());
        }
        //3、释放资源
        fos.close();
    }
}
