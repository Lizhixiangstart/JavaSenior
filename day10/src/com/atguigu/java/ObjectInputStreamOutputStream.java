package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 *1.ObjectInputStreamOutputStream
 * 2.作用：用于存储和读取基本数据类型或对象的处理流。它的强大之处在于可以把对象存储进磁盘当中进行保存
 *3要想一个java对象是可序列化的，需要满足相应的要求。见Person.java
 *
 * 4序列化机制：
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而循序把这种
 * 二进制持久地保存再磁盘上，或通过网络将这种二进制流传输到另一个网络节点
 * 当其他程序获取了这种二进制，就可以恢复成原来的java对象
 *
 *
 *
 *
 * @author lzx
 * @create 2022-04-2022/4/26 17:39
 */
public class ObjectInputStreamOutputStream {
    /*
    * 序列化过程：将内存中的java对象保存到磁盘中通过网络传输出去
    * 使用ObjectOutputStream
    * */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            //1
            oos = new ObjectOutputStream(new FileOutputStream("object.data"));
            //2
            oos.writeObject(new String("我爱你"));
            oos.writeObject(new Person("李志祥",20));
            oos.writeObject(new Person("陈敏",22,new Account(1000)));
            oos.flush();//刷新操作
            //3

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
/*
* 反序列化：将磁盘文件中的对象还原位内存中的一个java对象
* 使用ObjectInputStream实现
* */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.data"));

            Object obj = ois.readObject();
            String str = (String)obj;

            Person p = (Person) ois.readObject();
            Person p1 = (Person) ois.readObject();
            System.out.println(obj);
            System.out.println(p.toString());
            System.out.println(p1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
