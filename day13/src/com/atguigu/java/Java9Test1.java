package com.atguigu.java;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @author lzx
 * @create 2022-05-2022/5/30 19:23
 */
public class Java9Test1 {
    //java9新特性八：集合工厂方法：创建只读集合
    //java8中的写法：
    @Test
    public void test1(){

        List<String> nameList = new ArrayList<>();
        nameList.add("Joe");
        nameList.add("Bob");
        nameList.add("Bill");
        nameList = Collections.unmodifiableList(nameList);
        //返回的nameList是一个只读的集合
        nameList.add("Tom");
        System.out.println(nameList);


    }
    @Test
    public void test2(){
        List<String> list = Collections.unmodifiableList(Arrays.asList("a","b","c"));
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a","b","c")));
        //如下操作不适用于jdk8及之前版本，适用于jdk9
        Map<String,Integer> map = Collections.unmodifiableMap(new HashMap<>(){
            {
                put("a",1);
                put("b",20);
                put("c",3);
            }
        });
        map.forEach((k,v) -> System.out.println(k+":"+v));

    }

    @Test
    public void test3(){
        //此时的带的集合List也是只读
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //报异常
        list.add(6);

    }
    @Test
    public void test4(){
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        //不能添加
        //list1.add(6);

        System.out.println(list1);

        Set<Integer> set1 = Set.of(23, 45, 68, 33);
        //不能添加
       // set1.add(99);
        System.out.println(set1);


        Map<String, Integer> map1 = Map.of("Tom", 23, "Jerry", 54, "HanMeimei", 12);
        //不能添加
        //map1.put("Jack",60);
        System.out.println(map1);

        Map<String,Integer> map2 = Map.ofEntries(Map.entry("Tom", 23),Map.entry("Jerry",30));
        //不能添加
        //map2.put("Lilei",30);
        System.out.println(map2);
    }
    //java9新特性九：InputStream的新方法：transferTo()
    @Test
    public void test5(){
        ClassLoader cl = this.getClass().getClassLoader();
        try (InputStream is = cl.getResourceAsStream("hello.txt");
             OutputStream os = new FileOutputStream("hello1.txt")){
            is.transferTo(os);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
