package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*如何自定义范型结构：泛型类、泛型接口、泛型方法
 *
 * 1.关于自定义泛型类、泛型接口
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //如果定义了泛型类，实例化时没有指明次泛型类型，默认为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时用上
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");
        System.out.println(order);
        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<String>("AA",1001,"AA");

        order1.setOrderT("AA:hello");
        System.out.println(order1);

    }
    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型
        sub1.setOrderT(1122);
        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("order2...");
    }
    @Test
    public void test3(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2=null;
//        list1 = list2;

        Person p1 = null;
        Person p2 = null;

    }
    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = order.copyFromArrayList(arr);
        String[] arr1 = new String[]{"AA","BB"};
        List<Object> str = order.copyFromArrayList(arr1);
        System.out.println(list);


    }
}
