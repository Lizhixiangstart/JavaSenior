package com.atguigu.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器形参列表一致
 *      抽象方法的返回值类型即为构造器所属的类的类型
 * 二、数组引用
 *      大家可以把数组看成一个特殊的类
 *
 * @author lzx
 * @create 2022-05-2022/5/16 1:58
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        sup.get();

        System.out.println("*************");

        Supplier<Employee> sup1 = () -> new Employee();
        sup1.get();
        System.out.println("**************");

//        Supplier<Employee> sup2 = () -> Employee :: new;
//        System.out.println();
    }

    //Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> func1 = id -> new Employee(id);
        Employee employee = func1.apply(1001);

        System.out.println("************");

        Function<Integer,Employee> func2 = Employee :: new ;
        func2.apply(1002);
    }

    //BiFunction中的 R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> func1 = (id,name) -> new Employee(id,name);
        System.out.println(func1.apply(1001, "Jerry"));

        System.out.println("*************");

        BiFunction<Integer,String,Employee> func2 = Employee :: new;
        System.out.println(func2.apply(1002,"Tom"));

    }
    //数组的引用
    public void test4(){
        Function<Integer,String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("*****************");

       /* Function<Integer, String> func2 = String[]::new;
        String arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));*/
    }
}
