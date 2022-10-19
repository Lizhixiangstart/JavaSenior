package com.atguigu.java4;

/**
 * @author lzx
 * @create 2022-05-2022/5/21 11:12
 */
public class Girl {
    private String name;

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }
}
