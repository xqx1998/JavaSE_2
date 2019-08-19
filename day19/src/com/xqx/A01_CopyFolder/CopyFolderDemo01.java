package com.xqx.A01_CopyFolder;

import java.io.*;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/15 10:15
 * description:
 * 需求:复制单级文件夹
 */
public class CopyFolderDemo01 {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("day19//src//com//xqx//A01_Buffered");
        File destFile = new File("day19");
        copyFolder(srcFile,destFile);
    }

   /* public static void copy(File file1, File file2){
        File[] files = file1.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                file2.mkdirs();
            }else{

            }
        }
    }*/

    /**
     *复制目录
     * @param srcFile 数据源 要复制的目录
     * @param destFile 目的地
     */
   public static void copyFolder(File srcFile, File destFile) throws IOException {
       //获取数据源目录名称
       String folderName = srcFile.getName();
       //创建新目录对象
       File newFile = new File(destFile, folderName);
       //判断新目录是否存在  不存在：创建目录
       if(!newFile.exists()){
           newFile.mkdirs();
       }
       //获取数据源目录下所有文件
       File[] files = srcFile.listFiles();
       //遍历每一个文件并复制
       for (File file : files) {
            copyFile(file,newFile);
       }
   }

    /**
     *复制文件
     * @param srcFile  要复制的文件
     * @param folderFile  复制到该目录中
     */
   public static void copyFile(File srcFile, File folderFile) throws IOException {
       //创建输入和输出字节流
       // FileInputStream fileInputStream = new FileInputStream(srcFile);
       BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFile));
       BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(folderFile, srcFile.getName())));
       //创建缓冲字节流数组
       byte[] bytes = new byte[1024];
       int len = 0;
       //读数据源文件 写入新文件
       while ((len=bufferedInputStream.read(bytes))!=-1){
           bufferedOutputStream.write(bytes,0,len);
       }
       // 释放资源
       bufferedInputStream.close();
       bufferedOutputStream.close();
   }
}
