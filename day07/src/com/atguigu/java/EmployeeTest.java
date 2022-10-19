package com.atguigu.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的5个对象，并把这些对象放入TreeSet集合中(下一章：TreeSet需要使用泛型来定义)
 * 分别按一下两种方式对集合中的元素进行排序，并遍历输出；
 * 1)使用Empolyee实现Comparable接口，并按name排序
 * 2)创建TreeSet时传入Comparator对象，按生日日期的先后顺序排序
 * @author lzx
 * @create 2022-03-2022/3/15 17:18
 */
public class EmployeeTest  {

    @Test
    public void test2(){



        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee|| o2 instanceof Employee){
                Employee e1 = (Employee) o1;
                Employee e2 = (Employee) o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    //比较年
                    int minusYear = b1.getYear() - b2.getYear();
                    if (minusYear !=0){
                        return minusYear;
                    }
                    //比较月
                    int minusMonth = b1.getMonth()- b2.getMonth();
                    if (minusMonth !=0){
                        return minusMonth;
                    }
                    //比较日
                    return b1.getDay()-b2.getDay();

                }
                throw new RuntimeException("传入的数据类型不一致");
            }
        });

        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("hangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofuchneg", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test1() {
        TreeSet set = new TreeSet();

        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("hangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofuchneg", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }



}
