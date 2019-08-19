package com.xqx.A01_byteStream_.A01_bufferStream;


import java.io.*;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/13 9:36
 * description:
 */
public class Copy_FileStreamDemo02 {
    public static void main(String[] args) throws IOException {
        fileCopy("D:\\ftp共享\\SoftwareInstallPackages\\eNSP V100R002C00B510 Setup.zip",
                "day18\\FileCopy_eNSP V100R002C00B510 Setup.zip");

    }

    public static void fileCopy(String path1, String path2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path1);
        FileOutputStream fileOutputStream = new FileOutputStream(path2);
        Long start = System.currentTimeMillis();
        //读取数据
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        //释放资源
        fileInputStream.close();
        //释放资源
        fileOutputStream.close();
        if (new File(path2).exists()) {
            Long end = System.currentTimeMillis();
            System.out.println("基础流复制文件成功！耗时" + (end - start) + " 路径：" + new File(path2).getAbsolutePath());
        }
    }
}
/**
 * 基础流复制文件成功！耗时11038 路径：G:\DarkHorseCode\JavaSE_2\day18\FileCopy_eNSP V100R002C00B510 Setup.zip
 */
