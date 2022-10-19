package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections：操作Collection、Map的工具类
 *
 *
 * 面试题：
 * Collectiopn和Collections的区别?
 * Collection
 *
 * @author lzx
 * @create 2022-03-2022/3/17 23:04
 */
public class CollectionsTest {
    /*
    * reverse(List):反转List中元素的顺序
    * shuffle(List):对List集合元素进行随机排序
    * sort(List):根据元素的自然顺序对指定List集合元素按升序排序
    * sort(List,Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
    * swap(List,int i,int j):将指定List集合中的i处元素与j处元素进行交换
    *
    * Object max(Collection):根据元素的自然顺序，返回给定集合中的最大元素
    * Object max(Collcetion,Comparator):根据Comparator指定的顺序，返回给定集合中的最大元素
    * Object min(Collection):
    * Object min(Collection,Comparator):
    * int frequency(Collection,object):返回指定集合中指定元素的出现次数
    * void copy(List dext,List src):将src中的内容复制到dest中
    * boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换list
    * */
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println(list);
        //报异常：IndexOutOfBoundsException
//        List dest = new ArrayList();
//        Collections.copy(dest,list);
        //正确的
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);

        System.out.println(dest);

    }
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println(list);

//        Collections.reverse(list);
//          Collections.shuffle(list);
//          Collections.sort(list);
        Collections.swap(list,1,2);
        System.out.println(list);
    }
}
