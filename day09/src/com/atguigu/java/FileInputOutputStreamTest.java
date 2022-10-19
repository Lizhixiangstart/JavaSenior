package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputOutputStream测试
 *
 * 结论：
 * 1.对于文本文件(txt,java,c,cpp)，使用字符流处理
 * 2.对于非文本文件(jpg,mp3,mp4mavi,dpc,ppt)，使用字节流处理
 * @author lzx
 * @create 2022-04-2022/4/23 1:55
 */
public class FileInputOutputStreamTest {
    @Test
    public void testFIleInputStream() throws IOException {
        //1.造文件
        File file = new File("hello.txt");
        //2.造流
        FileInputStream fis = new FileInputStream(file);
        //3.读数据
        byte[] buffer = new byte[5];
        int len ;
        while ((len = fis.read(buffer)) != -1){
            String str = new String(buffer,0,len);
            System.out.println(str);
        }

    }

    /*
    * 实现对图片的复制操作
    * */
    @Test
    public void testFileInputOutputStream(){
        //
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("敏.jpg");
            File destFile = new File("敏2.jpg");
            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制过程
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            try {
                if(fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }




        }

    }
    //指定路径下文件的复制
    public void copyFile(String scrPath,String destPath){
        //
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(scrPath);
            File destFile = new File(destPath);
            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            try {
                if(fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }




        }
    }
    @Test
    public void testCoptFile(){
        long start = System.currentTimeMillis();
        String srcFile = "F:\\四级听力录音\\2020-09-1.MP3";
        String destFile = "F:\\四级听力录音\\2020-09-02.MP3";
        copyFile(srcFile,destFile);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+(end-start));
    }

}

