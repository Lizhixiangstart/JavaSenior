package com.atguigu.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1.使用情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 *
 *2.方法引用本质上就是lambda表达式，而lambda表达式作为函数式接口的实例出现
 * 方法引用，也是函数式接口的实例
 *
 * 3.使用格式：  类(或对象) :: 方法名
 *
 * 4.具体分为如下的三种情况
 *  对象::非静态方法(实例方法)
 *  类::静态方法
 *  类::非静态方法
 *
 * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型
 *
 * 方法引用使用要求：接口中的抽象方法的形参列表和返回值类型要与方法引用方法的形参列表和返回值类型相同
 * （针对于情况1和情况2）
 *
 *
 *
 * @author lzx
 * @create 2022-05-2022/5/16 1:06
 */
public class MethodRefTest {
    //情况一：对象::实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
   @Test
    public void test1(){
       Consumer<String> con1 = str -> System.out.println(str);
       con1.accept("北京");

       System.out.println("******************");
       PrintStream ps = System.out;
       Consumer<String> con2 = ps::println;
        con2.accept("beijing");
   }
    //Supplier中的T get()
    //Employee中String getName()
    public void test2(){
       Employee emp = new Employee(1001,"Tom",23,5600);
        Supplier<String > sup1 = ()-> emp.getName();
        System.out.println(sup1.get());
        System.out.println("****************");
        Supplier<String > sup2 = emp :: getName;
    }

    //情况三： 类::实例方法(有难度)
    //Comparator 中的int compare(T t1,T t2)
    //String 中的int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<String > com1 = (s1,s2) ->s1.compareTo(s2);
        System.out.println(com1.compare("abc","abd"));

        System.out.println("********************");

        Comparator<String> com2 = String :: compareTo;
        System.out.println(com2.compare("abc","abm"));

    }

    @Test
    public void test6(){
        BiPredicate<String,String> pre1 = (s1,s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc","abc"));

        System.out.println("**************************");
        BiPredicate<String,String> pre2 = String :: equals;
        System.out.println(pre2.test("abc","abd"));
    }
    //Function中R apply(T t)
    //Employee中String getName()
    @Test
    public void test7(){
        Employee employee = new Employee(1001, "Jerry", 23, 4000);

        Function<Employee,String> func1 = e -> e.getName();
        System.out.println(func1.apply(employee));

        System.out.println("*********************");

        Function<Employee,String > func2 = Employee :: getName;
        System.out.println(func2.apply(employee));
    }
}
