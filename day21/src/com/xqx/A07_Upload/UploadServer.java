package com.xqx.A07_Upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * createAuthor：xingquanxiang
 * createTime：2019/8/18 18:09
 * description:
 * //前提：创建Socket对象，响应客户端连接
 * <p>
 * //1、从网络输入流中读取文件
 * <p>
 * //2、将文件写到本地磁盘中
 * <p>
 * //6、使用网络输出流回复客户端消息
 */
public class UploadServer {
    public static void main(String[] args) throws IOException {
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 前提：创建Socket对象，响应客户端连接
        ServerSocket serverSocket = new ServerSocket(10010);
        while (true) {
            Socket socket = serverSocket.accept();
            //方法1:开启一个线程  问题：会无限创建线程，造成资浪费
            //方法2：将任务交给线程池执行
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    FileOutputStream fileoutputStream = null;
                    try ( InputStream inputStream = socket.getInputStream();){
                        // 1、从网络输入流中读取文
                        // 2、将文件写到本地磁盘中
                        //定义上传文件夹
                        File uploadFolder = new File("day21//upload");
                        //判断上传文件夹是否存在 硬盘上 没有：则创建
                        if (!uploadFolder.exists()){
                            uploadFolder.mkdirs();
                        }
                        // 创建缓冲流字节数组
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        //读取上传的文件名称
                        if ((len=inputStream.read(bytes))!=-1){
                            System.out.println("len = " + len);
                            System.out.println("new String(bytes,0,len) = " + new String(bytes, 0, len));
                            fileoutputStream = new FileOutputStream(new File(uploadFolder,new String(bytes,0,len)));
                        }
                        //从硬盘读文件 向网络流中写文件
                        while ((len = inputStream.read(bytes)) != -1) {
                            fileoutputStream.write(bytes, 0, len);
                            fileoutputStream.flush();
                        }

                        // 6、使用网络输出流回复客户端消息
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("文件上传成功！".getBytes());
                        outputStream.flush();

                        //释放资源
                        fileoutputStream.close();
                        // socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (fileoutputStream!=null){
                            try {
                                fileoutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
        // serverSocket.close();
    }



}
