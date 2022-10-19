package com.atguigu.java1;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author lzx
 * @create 2022-05-2022/5/31 14:59
 */
public class Java11Test {
    //java11新特性一：String中新增的方法
    @Test
    public void test1(){
        //isBlank():判断字符串是否为空白
       System.out.println("\t \t \n".isBlank());
       //strip():
        System.out.println("___"+"\t abc \t \n".strip()+"___");
        System.out.println("___"+"\t abc \t \n".trim()+"___");
        //stripTrailing():去尾空白
        System.out.println("___"+"\t abc \t \n".stripTrailing()+"___");
        //stripLeading():去头空白
        System.out.println("___"+"\t abc \t \n".stripLeading()+"___");
        //repeat(int count):
        String str1 = "abc";
        String str2 = str1.repeat(3);
        System.out.println(str2);
        //lines().count():判断字符串多少行

         var a =new  HashMap<String,Integer>();
         a.put("李志杰",18);
         a.put("李志祥",20);
        Set<String> keySet = a.keySet();
        Collection<Integer> values = a.values();
        Set<Map.Entry<String, Integer>> entries = a.entrySet();
        for(int i=0;i<a.size();i++){
            System.out.println();
        }
    }
    //java11新特性二：Optioncal新增的方法
    @Test
    public void test2(){
        Optional<Object> op = Optional.empty();
        System.out.println(op.isPresent());//判断内部value是否存在
        System.out.println(op.isEmpty());//判断内部的value是否为空

        op = Optional.of("abc");
        //orElseThrow():入宫Optional内部value非空则输出value，如果为空则抛出异常
        var obj = op.orElseThrow();
        System.out.println(obj);
        
        //or
        Optional<String> op1 = Optional.of("hello");
        //or():value非空，返回对应的Optional；value为空，返回形参列表封装的Optional
        Optional<Object> op2 = op.or(() -> op1);
        System.out.println(op2);
    }
    //Java11新特性三：局部变量类型推断的升级
    @Test
    public void test3(){
        //错误的形式：必须要有类型，可以加上var
        //Consumer<String> con1 = (@Deprecated t) -> System.out.println(t.toUpperCase())
        //正确的形式：
        //使用var的好处是在使用Lambda表达式时给参数加上注解
        Consumer<String> con1 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }
    @Test
    public void test4(){
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("李志杰",20);
        System.out.println(map1);
        map1.put("李志祥", 21);
        Set<Map.Entry<String, Integer>> entries = map1.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey()+"年龄为："+next.getValue());
        }
    }

}
