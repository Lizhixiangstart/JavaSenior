package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author lzx
 * @create 2022-04-2022/4/30 22:42
 */
public class Creature <T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    private void eat(){
        System.out.println("生物吃东西");
    }
}
