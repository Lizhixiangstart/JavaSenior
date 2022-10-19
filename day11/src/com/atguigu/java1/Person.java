package com.atguigu.java1;

/**
 * @author lzx
 * @create 2022-04-2022/4/30 22:42
 */
@MyAnnotation(value= "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
    private String name;
    int age;
    public int id;

    public Person(){}
    @MyAnnotation(value= "abc")

    private Person(String name){
        this.name = name;
    }
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    @MyAnnotation

    private String show(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;
    }

    private String display(String intreasts){
        return intreasts;
    }


    @Override
    public String
    toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}
