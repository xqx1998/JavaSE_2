package CourseLearn.xqx_6;

import java.io.FileOutputStream;
import java.io.IOException;

/*
    问题：异常处理
    我们刚刚都是将异常抛出了，jvm默认是中断处理
    应该要将异常捕获处理，最终一定要释放资源。异常捕获快捷键 ctrl+alt+t
 */
public class FileOutputStreamDemo03 {
    public static void main(String[] args) {
        //1、创建流对象
//        FileOutputStream fos=new FileOutputStream("day08/fos.txt");
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream("day10/fos.txt",true);
            //2、调用write方法写数据
            for (int i = 0; i < 10; i++) {
                fos.write("杨锌怒是这条街最靓的仔\r\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //3、释放资源
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("后续代码");
    }
}
