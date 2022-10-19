package com.atguigu.java;

import org.junit.Test;


/**
 * 关于StringBuffer和StringBuilder的使用
 * @author lzx
 * @create 2021-12-2021/12/25 9:39
 */
public class StringBufferBuilderTest {
  /*
  StringBuffer的常用方法：
  StringBuffer append(xxx):提供了很多append()方法，用于进行字符串拼接
  StringBuffer delect(int start,int end):删除指定位置的内容
  StringBuffer replace(int start,int end,String str):把[start,end)位置替换成str
  StringBuffer insert(int offset,xxx)：在指定位置插入xxx
  StringBuffer reserve():把当前字符序列逆转
  public int indexOf(String str)
  public String substring(int start,int end):返回一个从start开始到end结束的左闭右开区间的子字符串
  public int length()
  public char charAt(int n)
  public void serCharAt(int n,char ch)

    总结：
    增：append(xxx)
    删：delect(int start,int end)
    改：setCharAt(int a,char ch)/replace(int start,int end)
    查：charAt(int n)
    插：insert(int offset,xxx)
    长度：length()
    遍历：for()+charAt()/toString()
   */
@Test
public void test2(){
    StringBuffer s1 = new StringBuffer("abc");
    s1.append(1);
    s1.append("1");
//    s1.delete(2,4);
//    s1.replace(2,4,"hello");
//    s1.insert(2,"false");
//        s1.reverse();
    String s2 = s1.substring(1,3);
    System.out.println(s2);
    System.out.println(s1);
    System.out.println(s1.length());
}



    /*
    String、StringBuffer、StringBuilder三者的异同？
    String：不可变的字符序列；底层使用char[]进行存储
    StringBuffer：可变的字符序列；线程安全的，效率低；底层使用char[]存储
    StringBuilder：可变的字符序列；jdk5.0新增线程不安全的，效率高;底层使用char[]存储

        源码分析：
        String str = new String();new char[0];
        String str1 = new String("abc");new char[]{'a','b','c'};

        StringBuffer sb1 = new StringBuffer();new char[16];底层创建了一个长度是16的char[]
        sb1.append('a');value[0] = 'a';
        sb1.append('b');value[1] = 'b';

        StringBuffer sb2 = new StringBuffer("abc");char [] value = new char["abc".length+16];

        问题1.System.out.println(sb2.length());//3
        问题2.扩容问题：如果添加的数据底层数组盛不下了，那就需要扩容底层数组。
                    默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中。

                    指导意义：开发中建议使用StringBuffer(int capacity)或StriingBuilder(int capacity)

     */

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0
    }
}
