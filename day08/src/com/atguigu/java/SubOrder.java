package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzx
 * @create 2022-03-2022/3/19 12:37
 */
public class SubOrder extends Order<Integer>{//SubOrder不再是泛型类
    public <E> List<E> copyFromArrayList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e :arr){
            list.add(e);
        }
        return list;
    }
}
