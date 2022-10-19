package com.atguigu.java;

/**
 * MyDate类包含：
 * private成员变量year，month，day，并为每一个属性定义getter，setter方法
 * @author lzx
 * @create 2022-03-2022/3/15 17:04
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDaye{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
