package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BUfferedReader
 * BUfferedWriter
 *
 * 2.作用：提高流的读取，写入的速度
 * 提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流;jiushi “嵌套”在已有的流的基础上
 *
 *
 * @author lzx
 * @create 2022-04-2022/4/23 13:54
 */
public class BufferTest {
    /*
    * 实现非文本文件的复制
    * */
    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1造文件
            File scrFile = new File("敏.jpg");
            File destFile = new File("敏3.jpg");
            //2.造流
            //2.1造节点流
             FileInputStream fis = new FileInputStream(scrFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //4。资源关闭
        //要求1:先关闭外层的流，再关闭内层的流
        //说明：在关闭外层流的同时，内层流也会自动关闭，关闭内层流我们可以省略
    }

    //实现复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1造文件
            File scrFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(scrFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节：读取写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //4。资源关闭
        //要求1:先关闭外层的流，再关闭内层的流
        //说明：在关闭外层流的同时，内层流也会自动关闭，关闭内层流我们可以省略
    }

    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();
        String srcPath = "F:\\四级听力录音\\2020-09-1.MP3";
        String destPath = "F:\\四级听力录音\\2020-09-2.MP3";
        copyFileWithBuffered(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+(end-start));
    }

    /*
    * 使用BufferedReader和BUfferedWriter实现文本文件的复制
    * */
    @Test
    public void testBufferedReaderWriter(){
        //创建文件和相应的流
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello1.txt")));
            //读写操作
            //方式一：cahr数组
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//                bw.flush();
            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null){
                bw.write(data+"\n");//data中不包含换行符
                bw.newLine();//提供换行的操作
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
