package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream终止操作
 * @author lzx
 * @create 2022-05-2022/5/21 9:49
 */
public class StreamAPITest2 {
    //1匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

//        allMatch(Predicate p):检查是否匹配所有元素
        //练习：是否所有员工的年龄都大于18岁
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

//        anyMatch(predicate p):检查是否有一个元素匹配
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 9000);
        System.out.println(anyMatch);

//        noneMatch(Predicate p):检查是否没有一个匹配
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

//        findfirst():返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);

//        findAny():返回任意一个
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
    }
    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
        //count():返回流中元素的个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

//        max(Comparator c)：返回流中最大值
        //练习：返回最高的工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compare);
        System.out.println(maxSalary);

//        min(Comparator c):返回流中最小值
        //练习：返回最低工资的员工
        Optional<Employee> minSalary = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(minSalary);

//        forEach(Consumer c)内部迭代
        employees.stream().forEach(System.out :: println);
        //使用集合的遍历操作
        employees.forEach(System.out :: println);

    }
    @Test
    public void test3(){
//        reduce(T idenity,BinaryDperator):可以将流中元素反复结合起来，得到一个值
        //练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

//        reduce(BinaryOperator)可以将流中元素反复结合起来，得到一个值，返回一个Optional<>
        //练习2：计算公司所有员工工资总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
       // Optional<Double> sumMoney = salaryStream.reduce(Double::sum);
        Optional<Double> sumMoney = salaryStream.reduce((d1, d2) -> d1 + d2);
        System.out.println(sumMoney);
    }
    //3收集
    @Test
    public void test4(){
//        collect(Collectors c):将流转换为其他形式。接收一个Collector接口实现类的对象
        //练习1：查找工资大于6000的员工，结果返回一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out :: println);


        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out :: println);
    }
}
