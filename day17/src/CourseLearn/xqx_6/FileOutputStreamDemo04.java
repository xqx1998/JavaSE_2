package CourseLearn.xqx_6;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo04 {
    public static void main(String[] args){
        FileOutputStream fos= null;
        try {
            //1、创建流对象
//        FileOutputStream fos=new FileOutputStream("day08/fos.txt");
            fos = new FileOutputStream("day08/fos.txt",true);
            //2、调用write方法写数据
            for (int i = 0; i < 10; i++) {
                fos.write("杨锌怒是这条街最靓的仔\r\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3、释放资源
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
