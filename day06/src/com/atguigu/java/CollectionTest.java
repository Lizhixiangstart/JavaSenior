package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * Collection接口中声明的方法的测试
 *结论：
 * 向Collection接口的是实现类的的对象中添加数据obj时，要求obj所在的类重写equals()
 *
 * @author lzx
 * @create 2022-03-2022/3/9 14:07
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jerry",20));


        //1contains(Object obj):判断当前集合是否包含obj
        //我们在判断时会调用obj对象所在类的equals()
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains("Tom"));
        System.out.println(coll.contains(new Person("Jerry",20)));

        //2containsALL(Collcetion coll1):判断coll1中的所有元素是否都存在于当前集合中
        Collection coll1 =  Arrays.asList(123,456);

        System.out.println(coll.containsAll(coll1));


    }
    @Test
    public void test2(){
        //3remove(Object obj):从当前集合中删除obj元素

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jerry",20));

        coll.remove(123);
        System.out.println(coll);
        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4removeAll(Collcetion coll1):差集：从当前集合中移除coll1中所有集合
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }
    @Test
    public void test3(){
        Collection  coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add("Tom");
        coll.add(false);

//        //5retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);


        //6equals(Object obj):要想返回true，需要当前集合和coll内容完全相同
//        Collection  coll1 = new ArrayList();
//        coll1.add(123);
//        coll1.add(456);
//        coll1.add(new Person("Jerry",20));
//        coll1.add("Tom");
//        coll1.add(false);
//        System.out.println(coll.equals(coll1));
    }
    @Test
    public void test4(){
        Collection  coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add("Tom");
        coll.add(false);
        //7hashCode():返回当前对象的当前值
        System.out.println(coll.hashCode());

        //8集合-->数组：toArray()
        Object [] arr = coll.toArray();
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        //拓展：数组-->集合:调用Arrays类的静态方法asList()
        List list = Arrays.asList("AA", "BB", "CC");
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(123, 456);
        System.out.println(arr2.size());//2

        //iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中
    }
}
