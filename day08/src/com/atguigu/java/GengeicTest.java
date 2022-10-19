package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/*
 *泛型的使用：
 * 1.jdk5.0新增的使用
 *
 * 2.在集合中使用泛型：
 * 总结：
 * ①集合接口或集合类在jdk5.0时，都修改为带泛型的接口
 * ②在实例化集合类时，可以指明具体的泛型类型
 * ③指明以后，在集合类或接口中凡是定义类或接口时，内部结构(比如：方法、构造器、属性)使用到类的泛型的位置
 *      比如：add(E e)-->实例化以后：add(Integer e)
 * ④注意点：泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型的位置
 * ⑤如果实例化时，没有指明泛型的类型，默认类型为java.lang.object类型
 *
 * 3.如何自定义范型结构：泛型类、泛型接口、泛型方法
 * @author lzx
 * @create 2022-03-2022/3/19 11:43
 */
public class GengeicTest {
    //在集合中使用泛型之前的情况：
    @Test
    public void test1(){
    ArrayList list = new ArrayList();
    //需求：存放学生的成绩
    list.add(78);
    list.add(76);
    list.add(89);
    list.add(88);
    //问题一：类型不安全
//    list.add("Tom");

    for (Object score:list){
        //问题二：强转时，有可能出现ClassCastException
        int stuScore = (int)score;

        System.out.println(stuScore);
    }
    }
    //在集合中使用泛型的情况:以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //在编译时进行类型检查，保证数据安全
//        list.add("Tom");
        //方式一;
//        for (Integer score : list){
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
        //方式二：
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()){
                int stuScore = iterator.next();
                System.out.println(stuScore);
            }
        }
        //在集合中使用泛型：以HashMap为例：
        @Test
    public void tese3(){
           // HashMap<String , Integer> map = new HashMap<String,Integer>();
            //jdk7新特性类型推断
            HashMap<String , Integer> map = new HashMap<>();

            map.put("Tom",87);
            map.put("Jerry",87);
            map.put("Jacj",67);

//            map.put(123,"ABC");
            //泛型的嵌套
            Set<Map.Entry<String, Integer>> entry = map.entrySet();
            Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

            while (iterator.hasNext()){
                Map.Entry<String, Integer> next = iterator.next();
                String key = next.getKey();
                Integer value = next.getValue();

            }

        }
    }

