package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * 测试Stream
@author lzx
@create 2022-05-2022/5/16 19:42
 */
public class StreamTestAPITest1 {
    //1.筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
//    filter(Predicate p)——接收 Lambda。从流中排除某些元素
        Stream<Employee> stream = list.stream();
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out :: println);
        System.out.println();
//    limit(n)——判断流，使其元素不超过给定数量
       list.stream().limit(3).forEach(System.out :: println);
        System.out.println();
//    skip(n)——跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回
        list.stream().skip(3).forEach(System.out ::println);
        System.out.println();
//    ditinct()——筛选。通过流所生成元素的hashCode()和equals()去除重复元素
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));

        list.stream().distinct().forEach(System.out :: println);
        Stream<Employee> stream1 = list.stream();
        System.out.println(list);

        System.out.println("********");
        stream1.distinct().forEach(System.out :: println);
    }
    //映射
    @Test
    public void test2(){
        //map(Function f)接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新元素
        //和javascript中的map函数一样，对容中的每个元素执行一次回调函数
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out :: println);


        //练习：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() >3).forEach(System.out :: println);

//        flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连成一个流
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTestAPITest1::formStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out :: println);
        });
        Stream<Character> characterStream = list.stream().flatMap(StreamTestAPITest1::formStringToStream);
        characterStream.forEach(System.out :: println);
    }
    public static Stream<Character> formStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    @Test
    public void test3(){
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list1.addAll( list2);
        System.out.println(list1);


    }
    //3排序
    @Test
    public void test4(){
     //sorted():自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out :: println);

        //抛异常，原因：Empoyee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out :: println);

//        sorted(Comparator com):定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2) -> {
            int ageValue = Integer.compare(e1.getAge(),e2.getAge());
            if(ageValue != 0){
                return ageValue;
            }else{
                return  -Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out :: println);
    }


}