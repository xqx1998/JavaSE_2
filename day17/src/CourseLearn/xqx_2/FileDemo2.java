package CourseLearn.xqx_2;

import java.io.File;

/*
    File(String pathname)：通过将给定的路径名字符串创建File对象。
    File(String parent, String child)：从父路径名字符串和子路径名字符串创建新的 File对象，一般parent表示父目录，child表示子文件或者目录。
    File(File parent, String child)：从父抽象路径名和子路径名字符串创建新的 File实例。
 */
public class FileDemo2 {
    public static void main(String[] args) {
        //File(String pathname)：通过将给定的路径名字符串创建File对象。
/*
        File f1=new File("G:\\DarkHorseCode\\JavaSE_2\\day17\\src\\day08晚自习");
       //创建单级目录
        f1.mkdir();
*/

        //在day08晚自习下面创建aaa/bbb/ccc目录
        File f2=new File("G:\\DarkHorseCode\\JavaSE_2\\day17\\src\\day08晚自习/aaa/bbb/ccc");
        f2.mkdirs();

        //在day08晚自习下面创建abc目录
        File f3=new File("G:\\DarkHorseCode\\JavaSE_2\\day17\\src\\day08晚自习/abc");
        f3.mkdirs();

        System.out.println("创建文件成功");
    }
}
