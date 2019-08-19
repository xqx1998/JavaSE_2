package com.xqx.A08_UploadExpand;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/18 18:09
 * description:
 * //前提：创建Socket对象，和服务器建立连接S
 * <p>
 * //1、从本地硬盘中读取要上传的文件
 * <p>
 * //2、使用网络输出流将内容写给服务器
 * <p>
 * //6、使用网络输入流读取服务器发回的消息
 */
public class UploadClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.上传文件  2.上传文件夹所有文件(不含子目录) 3.退出");
            switch (scanner.next()) {
                case "1":
                    while (true) {
                        System.out.println("请输入要上传的文件路径：（按1退出）");
                        String file = scanner.next();
                        if (file.equals("1"))
                            break;
                        else {
                            if (new File(file).exists()) {
                                uploadFile(file);
                            } else {
                                System.out.println("文件不存在！");
                            }
                        }
                    }
                    break;
                case "2":
                    while (true) {
                        System.out.println("请输入要上传的文件夹路径：（按1退出）");
                        String folder = scanner.next();
                        if (folder.equals("1"))
                            break;
                        else {
                            if (new File(folder).exists()) {
                                uploadFolder(folder);
                            } else {
                                System.out.println("文件不存在！");
                            }
                        }
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("指令输入有误！");
            }
        }
    }

    private static void uploadFolder(String folderPath) {
        File uploadFolder = new File(folderPath);
        if (uploadFolder.isDirectory()) {
            for (File file : uploadFolder.listFiles()) {
                if (file.isFile()) {
                    try {
                        System.out.print(file.getName());
                        uploadFile(file.getAbsolutePath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("文件夹路径错误！");
        }
    }

    public static void uploadFile(String filePath) throws IOException {
        // 前提：创建Socket对象，和服务器建立连接
        // Socket socket = new Socket("192.168.84.146", 10086);
        Socket socket = new Socket("127.0.0.1", 10010);
        // 1.从本地硬盘中读取要上传的文件
        // 定义要上传的文件
        File uploadFile = new File(filePath);
        //创建字节输入流读取文件
        FileInputStream fileInputStream = new FileInputStream(uploadFile);
        // 2.使用网络输出流将内容写给服务器
        OutputStream outputStream = socket.getOutputStream();
        //向网络输出流中写上传的文件名称 并刷新
       /* outputStream.write(uploadFile.getName().getBytes());
        outputStream.flush();*/
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(uploadFile.getName());
        bufferedWriter.flush();

        // 使用while循环读写
        byte[] bytes = new byte[1024];
        int len = 0;
        //读硬盘文件  写入网络流中
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
            outputStream.flush();
        }
        //向服务器发送结束标记
        socket.shutdownOutput();
        // 3.使用网络输入流读取服务器发回的消息
        InputStream inputStream = socket.getInputStream();
        len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //释放资源
        bufferedWriter.close();
        fileInputStream.close();
        socket.close();
    }


}
