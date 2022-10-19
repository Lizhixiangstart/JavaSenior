package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 * @author lzx
 * @create 2022-03-2022/3/19 12:24
 */
public class Order <T>{
    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型
    T orderT;
    public Order(){
        //编译不通过
//        T[] arr = new T[10];
        //
        T[] arr = (T [])new Object[10];

    }

    //如下的三个方法都不是泛型方法
    public Order(String orderName,int orderId,T orderT){
        this.orderName= orderName;
        this.orderId=orderId;
        this.orderT=orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT){

        this.orderT=orderT;
    }
//    //静态方法中不能使用类的泛型。
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    public void testshow(){
        //编译不通过
//        try {
//
//        }catch (T t){
//
//        }

    }
    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有关系
    //换句话说，反西宁方法所属的类是不是泛型类都没有关系
    //泛型方法可以声明为静态的。原因：泛型参数实在调用方法时确定，并非实在实例化时确定
    public <E> List<E> copyFromArrayList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e :arr){
            list.add(e);
        }
        return list;
    }
}
