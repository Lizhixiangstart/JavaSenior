package com.atguigu.java;

/**
 * @author lzx
 * @create 2022-04-2022/4/30 10:20
 */
public class Person {
    private String name;
    public int age;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("你好我是一个人");
    }
    private String showNation(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;
    }
}
