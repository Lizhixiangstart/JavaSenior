package com.atguigu.java;

import java.io.Serializable;

/**
 * Person需要满足如下的要求方可序列化：
 * 1.需要实现接口：Serializable
 * 2.当前类提供一个静态常量：serialVersionUID
 * 3.出了当前Person类需要实现Serializable接口之外，
 * 还需要其内部属性也必须可序列化的(默认情况下，基本数据类型都是可序列化的)
 * 4.被transient关键字修饰的属性不能被序列化
 *
 * 
 * @author lzx
 * @create 2022-04-2022/4/26 17:55
 */
public class Person implements Serializable {
    public static final long serialVersionUID =   11352151414L;
    private String name;
    private int age;
    private Account acct;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acct=" + acct +
                '}';
    }

    public Person(String name, int age, Account acct) {
        this.name = name;
        this.age = age;
        this.acct = acct;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Account implements Serializable{
    public static final long serialVersionUID = 11515262637L;
     private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}