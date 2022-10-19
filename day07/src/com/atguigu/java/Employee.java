package com.atguigu.java;

/**
 * 定义一个Employee类：
 * 该类包含：private成员变量name，age，birthday，其中birthdy为MyDate类的独享
 * 并为为一个属性定义getter，setter方法：
 * 并重写toSting方法输出name，age，birthday
 * @author lzx
 * @create 2022-03-2022/3/15 17:07
 */
public class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        }else {
            throw new RuntimeException("输入的数据类型不一致");
        }
    }
}
