package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK8.0之前日期和时间的API测试
 * @author lzx
 * @create 2021-12-2021/12/26 14:35
 */
public class DateTimeTest {
   /*
   java.util.Date类
           /---java.sql.Date类
   1.两个构造器的使用
   
   2.两个方法的使用
        >toSring():显示当前的年，月，日，时，分，秒
        >getTime():获取当前Date对象对应的毫秒数。(时间戳)

    3.java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转化为java.sql.Date对象
    */
    @Test
    public void tes2(){
            //构造器一：Date()：创建了一个对应当前时间的对象
        Date date1= new Date();
        System.out.println(date1.toString());//Sun Dec 26 22:21:23 CST 2021
        System.out.println(date1.getTime());//1640528543222

            //构造器二：常见指定毫秒数的Date对象
            Date date2 = new Date(1640528543222L);
            System.out.println(date2.toString());
            //创建java.sql.Date对象
            java.sql.Date date3 = new java.sql.Date(35235325345L);
        System.out.println(date3);

        //如何将java.util.Date对象转化为java.sql.Date对象
        //情况一：
        Date date4 = new java.sql.Date(234235345L);
        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
//        java.sql.Date date7 = (java.sql.Date) date6;
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

    }
    

    @Test
    public void test1(){
        //1.System类中currentTimeMillis()
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);

    }
}
