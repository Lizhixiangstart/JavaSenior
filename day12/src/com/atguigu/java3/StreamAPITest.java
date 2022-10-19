package com.atguigu.java3;

import com.atguigu.java2.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.Stream关注的是对数据的运算，与cpu打交道
 *      集合关注数据的存储，与内存打交道
 *
 * 2.注意点：
 * ①Stream  自己不会改变存储元素
 * ②Stream  不会改变源对象。相反，他们会返回一个持有结果的新Stream
 * ③Stream  操作是延迟执行的。这意味着他们呢会等到需要结果的时候才执行
 *
 * 3.Stream 执行流程
 * ①Stream的实例化
 * ②一系列的中间操作（过滤、映射……）
 * ③终止操作
 *
 * 4.说明：
 * 4.1一个中间操作链，对数据源的数据进行处理
 * 4.2一旦执行终止操作，就执行中间操作链，并产生结果，以后，不会再被使用
 *
 * 测试Stream的实例化
 *
 * @author lzx
 * @create 2022-05-2022/5/16 13:51
 */
public class StreamAPITest {
    //创建Stream方式一：通过集合
   @Test
    public void test1(){
       //default Stream<E> stream():返回一个顺序流
       List<Integer> list = Arrays.asList(1,2,3,4,5,6);
       Stream<Integer> stream = list.stream();

       //default Stream<E> parallelStream():返回一个并行流
       List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
       Stream<Integer> stream1 = list1.parallelStream();

   }



    //创建Stream方式二：通过数组
    @Test
    public void test2(){
        //调用Arrays类的static <T> Stream<T> stream(T[] arry):返回一个流
        int[] arr = new int[]{1,2,3,4,5,6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);


    }
    //创建Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Character> stream1 = Stream.of('我', '是', '谁');
        stream1.forEach(System.out :: println);
    }
    //创建Stream方式四：创建无限流
    @Test
    public void test4(){
       //迭代
        //public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> final)
        //遍历前十个偶数
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out :: println);


        //生成
        //public static<T> generate(Supplier<T> s)
        Stream.generate(Math :: random).limit(10);
    }

}
