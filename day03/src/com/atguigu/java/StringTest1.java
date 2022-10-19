package com.atguigu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 * @author lzx
 * @create 2021-12-2021/12/23 13:14
 */
public class StringTest1 {
    /*
    String 与byte[]之间的转换
    编码：String -->bytep[]：调用String的getBytes()

    编码：字符产 -->字节（看得懂 --->看不懂的二进制数据）
    解码：编码的逆过程 ，字节 -->字符串（看不懂的二进制数据--->看得懂）
     */

    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));
        System.out.println("*************");
        String str2 = new String(bytes);//使用默认的字符集，进行解码
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);

        String str4 = new String(gbks);
    }

    /*
    String与char[]之间的转换

    String --> char[]:调用String的toCharArray()
    char[] -->String:调用String的构造器（参数为数组对象）

     */
    @Test
    public void test2(){
        String str1 = "abc123"; //题目：a21cb3  思路：转换成char[]控制头和尾，反转
        char[] charArray = str1.toCharArray();
        for(int i=0;i<charArray.length;i++){
            System.out.println(charArray[i]);
        }

        char [] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    /*
    复习：
    String与基本数据类型、包装类之间的转换。
    String -->基本数据类型、包装累：调用包装类的静态方法：paseXxx(str)
    基本数据类型、包装类 -->String：调用String重载的valueOf(xxx)
     */
    @Test
    public void test1(){
        String str1 = "123";
//        int num = (int )str1;//错误的
        int num = Integer.parseInt(str1);
        String str2 = String.valueOf(num);
        String str3 = num+" ";

    }
}
