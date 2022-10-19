package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzx
 * @create 2022-05-2022/5/31 14:00
 */
public class Java10Test {
    /*
    java10新特性1：
    * 局部变量的类型推断
    * */
    @Test
    public void test1(){
        //1.声明变量时，根据所赋的值，推断变量的类型
        var num = 10;

        var list = new ArrayList<Integer>();
        list.add(123);

        //2.遍历操作
        for (var i : list){
            System.out.println(i);
            System.out.println(i.getClass());
        }

        //3.普通遍历操作
        for (int i =0;i<100;i++){
            System.out.println(i);
        }

    }
    @Test
    public void test2(){
        //1.局部变量不赋值就不能实现类型推断
        //var num
        var num = "hello";
        System.out.println(num.getClass());

        //2.Lambda表达式中，左边的函数式接口不能声明为var
        //Supplier<Double> sup = () -> Math.random();

        //var sup = () -> Math.random();

        //3.方法引用中，左边的函数式接口不能声明为var
        //Consumer<String> con = System.out::println;

       //var con = System.out::println;

        //4.数组的静态初始化中，注意如下的情况也不可以
        var arr = new int[]{1,2,3,4};
        //var arr = {1,2,3,4};

    }

    @Test
    public void test3(){
//        情况1：没有初始化的局部变量声明
//                var s = null;
//          情况2：方法的返回值类型
//          情况3：方法的参数类型
//          情况4：构造器的参数类型
//         情况5：属性
//        情况6：catch块
    }
    /*
    * java10新特性二：
    * 集合中新增的额不可变copyof()，用于创建一个只读的集合
    * */
    @Test
    public void test4(){
        //示例1：
        var list1 = List.of("Java","Python","C");
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1);//true

        //示例2：
        var list2 = new ArrayList<String>();
        list2.add("aa");
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2);//false

        //示例1和2代码基本一样，为什么一个为true，一个为false？
        //结论：copyof(Xxx coll):如果参数coll本身就是一个只读集合，则copyof方法即为当前col，
        //如果参数coll不是一个只读集合，则copyof()返回一个新的只读的

    }
}
