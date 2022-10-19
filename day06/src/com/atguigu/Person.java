package com.atguigu;

/**
 * @author lzx
 * @create 2022-03-2022/3/15 23:36
 */
public class Person {
     int id;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }
}
