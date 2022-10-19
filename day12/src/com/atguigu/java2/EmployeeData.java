package com.atguigu.java2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzx
 * @create 2022-05-2022/5/16 19:50
 */
public class EmployeeData {
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"马化腾",34,6000));
        list.add(new Employee(1002,"马云",12,9876));
        list.add(new Employee(1003,"刘强东",33,3000));
        list.add(new Employee(1004,"雷军",40,7632));
        list.add(new Employee(1005,"李彦宏",65,3333));
        list.add(new Employee(1006,"比尔盖茨",42,99999));
        list.add(new Employee(1007,"任正非",26,32633));
        list.add(new Employee(1008,"扎克伯格",53,2222));

        return list;
    }
}
