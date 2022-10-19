package com.atguigu.java;

import org.junit.Test;

import java.util.Optional;

/**
 * @author lzx
 * @create 2022-05-2022/5/28 13:07
 */
public class OptionalTest {
   @Test
    public void test1(){
       //empty():创建的Optional对象内部的value=null
       Optional<Object> op1 = Optional.empty();
       if(!op1.isPresent()){//Optional封装的数据是否包含数据
           System.out.println("数据为空");
       }
       //如果Optional封装的数据value为空，则get()报错。否则，value不为空时，返回value的值
       // System.out.println(op1.get());
       System.out.println(op1);
       System.out.println(op1.isPresent());

   }
   @Test
    public void test2(){
       String str = "hello";
       str = null;
       //of(T t):封装数据t生成Optional对象。要求t非空，否则报错
       Optional<String> op1 = Optional.of(str);
        //get(T t)通常于of()搭配使用，用于获取内部封装的数据
       String str1 = op1.get();
       System.out.println(str1);
   }

   @Test
    public void test3(){
       String str = "beijing";
       //ofnullable(T t):封装数据t给Optional内部的value，不要求t非空
       Optional<String> op1 = Optional.ofNullable(str);
       //orElse(T t):如果Optinal内部的value非空，则返回value，
       //value为空，则返回t1
       String str2 = op1.orElse("上海");
       System.out.println(str2);

   }
}
