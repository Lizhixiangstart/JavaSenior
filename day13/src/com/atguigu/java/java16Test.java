package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author lzx
 * @create 2022-05-2022/5/30 17:13
 */
public class java16Test {
    //
    @Test
    public void test1(){
        try {
            URL url = new URL("https://www.atguigu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //java9特性五：钻石操作符的升级
    @Test
    public void test2(){
        //钻石操作符与匿名内部类在java8中不能共存，在java9中可以
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        //jdk7中的新特性：类型推断
        ArrayList<String> list = new ArrayList<>();
    }

    //java9特性六：
    @Test
    public void test3(){
        //java8之前的资源关闭操作
//        InputStreamReader reader = null;
//        try {
//            reader = new InputStreamReader(System.in);
//            char[] cbff = new char[20];
//            int len;
//            if ((len = reader.read(cbff)) != -1){
//                String str = new String(cbff,0,len);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null){
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    //java8中资源关闭操作:java8可以实现资源的自动关闭
        //要求自动关闭资源的初始化必须放在try的一对小括号中
        try(InputStreamReader reader = new InputStreamReader(System.in)){
            char[] cbff = new char[20];
            int len;
            if((len = reader.read(cbff)) != -1){
                String str = new String(cbff,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //java9中资源的关闭操作：需要关闭资源的实例化可以放在一对小括号外
        //此时的资源实行是常量，声明为final，不可修改
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader){
            char[] cbff = new char[20];
            int len;
            if((len = reader.read(cbff)) != -1){
                String str = new String(cbff,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(System.in);
            char[] cbff = new char[20];
            int len;
            if ((len = reader.read(cbff)) != -1){
                String str = new String(cbff,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}}}
}
