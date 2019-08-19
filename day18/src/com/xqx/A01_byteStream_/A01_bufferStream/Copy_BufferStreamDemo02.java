package com.xqx.A01_byteStream_.A01_bufferStream;


import java.io.*;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/13 9:36
 * description:
 */
public class Copy_BufferStreamDemo02 {
    public static void main(String[] args) throws IOException {
        bufferCopy("D:\\ftp共享\\SoftwareInstallPackages\\eNSP V100R002C00B510 Setup.zip",
                "day18\\BufferCopy_eNSP V100R002C00B510 Setup.zip");
    }

    public static void bufferCopy(String path1, String path2) throws IOException {
        //创建字节缓冲输入流对象  读
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path1));
        //创建字节缓冲输出流对象  写
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path2));
        Long start = System.currentTimeMillis();
        //读取数据
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len=bufferedInputStream.read(bytes))!=-1) {
            bufferedOutputStream.write(bytes,0,len);
        }
        //释放资源
        bufferedInputStream.close();
        //释放资源
        bufferedOutputStream.close();
        if (new File(path2).exists()) {
            Long end = System.currentTimeMillis();
            System.out.println("高效缓冲流复制文件成功！耗时" + (end - start)+" 路径："+new File(path2).getAbsolutePath());
        }
    }

}
/**
 * 高效缓冲流复制文件成功！耗时1200 路径：G:\DarkHorseCode\JavaSE_2\day18\BufferCopy_eNSP V100R002C00B510 Setup.zip
 */
