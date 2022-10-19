package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFileTest的使用：
 * 1.RandomAccessFile直接继承于java.lang.Object,实现了DataInput和DataOutput接口
 * 2RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，将自动创建
 *      如果写出到的文件存在，则会对原有文件的内容进行覆盖，并且是从头覆盖
 *
 * 4.可以通过相关操作，可以实现插入数据的效果
 * @author lzx
 * @create 2022-04-2022/4/27 13:03
 */
public class RandomAccessFileTest {
    @Test
    //复制图片
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //1
            raf1 = new RandomAccessFile(new File("敏.jpg"),"r");
            raf2 = new RandomAccessFile(new File("敏2.jpg"),"rw");
            /*
            * r代表只读
            * rw代表即可读又可写
            * */

            //2
            byte[] buffer = new byte[1024];
            int len ;
            while ((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3
            if (raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
        raf1.seek(3);//将指针调到角标位3的位置
        raf1.write("xyz".getBytes());

        raf1.close();
    }
    /*
    * 使用RandomAccessFile实现数据的插入效果
    *
    * */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);//将角标定位到3的位置
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int)new File("hello.txt").length());
        /*
        * File long length():返回该file的文件长度，以字节为单位
        * */
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer,0,len));
        }
        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        //将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());


    }
}
