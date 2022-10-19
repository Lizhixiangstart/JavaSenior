package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author lzx
 * @create 2022-05-2022/5/30 20:55
 */
public class Java9Test2 {
    //java9新特性十：StreamAPI加强
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(23, 43, 45, 55, 61, 30, 99, 88);
        //takeWhile():从开头开始的按照指定规则的尽可能多的指定元素
        //list.stream().takeWhile(x -> x<60).forEach(System.out :: println);
        //dropWhile():与takeWhile相反（运算结果相反），返回剩余元素
       list.stream().dropWhile(x -> x<60).forEach(System.out :: println);
    }
    @Test
    public void test2(){
        //of()：参数中的多个元素，可以包含null值
        Stream<Integer> stream1 = Stream.of(1, 2, null);
        stream1.forEach(System.out :: println);
        //of():参数不能只存储单个null
        Stream<Object> stream2 = Stream.of(null);
        stream2.forEach(System.out :: println);
        //ofNullable():允许只存储一个null
        Stream<Integer> stream3 = Stream.ofNullable( null);
        stream3.forEach(System.out :: println);


    }
    @Test
    public void test3(){
        Stream.iterate(0,x->x+1).limit(10).forEach(System.out :: println);

        //java9中新增的重载方法
        Stream.iterate(0,x-> x < 100,x -> x+1).forEach(System.out :: println);
    }

    @Test
    public void test4(){
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");

        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<List<String>> stream = optional.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out :: println);

    }
}
