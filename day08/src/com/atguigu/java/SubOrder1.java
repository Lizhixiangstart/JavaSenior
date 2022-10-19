package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzx
 * @create 2022-03-2022/3/19 12:41
 */
public class SubOrder1 <T>extends Order<T> {//SubOrder1<T>；任然是泛型类

    public <E> List<E> copyFromArrayList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e :arr){
            list.add(e);
        }
        return list;
    }

}
