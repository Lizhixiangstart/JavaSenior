package com.atguigu.java;

import org.junit.Test;

/**
 * 1.int length():返回字符串的长度：return value.length
 * 2.char charAt(int index):返回某索引除的字符：return valu.length ==0
 * 3.boolean isEmpty():判断是否是空字符串:return value.length ==0
 * 4.String toLowerCase()；使用默认语言环境，将String中的所有字符转换为小写
 * 5.Sring toUpperCase()；使用默认语言环境，将String中所有字符转换为大写
 * 6.String trim()：返回字符串副本，忽略前导空白和尾部空白
 * 7.boolean equals(Object obj):比较i字符串内容是否相等
 * 8.Boolean equalsIgnoreCase(String anotherString):与equals方法类似，忽略大小写
 * 9.String contact(String str):将指定字符连接到此字符串的结尾，等于用"+"
 * 10.int compareTo(String anotherString):比较两个字符串大小
 * 11.String substring(int beginindex):返回一个新的字符串，它是此字符串的从beginIndex开始截取
 * 12.String substring(int beginIndex,int endIndex):返回一个新字符串，他是此字符串从begin开始end结束
 *
 *
 * @author lzx
 * @create 2021-12-2021/12/21 23:01
 */
public class StringMethodTest {
   /*

   String replace(char oldChar,char newChar):返回一个新的字符串，它是通过
   newChar 替换此字符串中出现的所有oldChar得到的
   String replace(CharSequence target,CharSequence replacement):使用之地那个的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
   String replaceAll(String regex,Striing replacement):使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串
   String replaceFirst(String regex,String replacement):使用给定的replacement替换此字符串批给给定的震泽表达式的第一个子字符串
   匹配：
   boolean match(String regex):告知此字符串啥都匹配给定的正则表达式
   切片：
   String [] split(String regex):根据给定的正则表达式的匹配拆分此字符串
   String [] split(String regex,int limit):根据匹配给定的正则表达式来拆分此字符串
   ，最多不超过limit个，如果超过了，剩下的全都放到最后一个元素中
    */
   @Test
   public void test4(){
        String str1 = "北京尚硅谷教育";
       String str2 = str1.replace("北", "东");
       System.out.println(str1);
       System.out.println(str2);
       String str3 = str1.replace("北京", "上海");
       System.out.println(str3);
       System.out.println("****************************");
       String str = "12hello34world5java7891mysql1456";
       //把字符串中的数字替换成”，“，如果结果开头和结尾有，的话去掉
       String string = str.replaceAll("\\d+",",").replaceAll("^,|,$","");
       System.out.println(str);

        str = "12345";
        //判断str字符串中是否全部由数字组成，既有1-n个数字组成
       boolean matches = str.matches("\\d+");

       String tel = "0571-4534289";
       //判断这是否是是一个杭州的固定电话
       boolean result = tel.matches("0571-\\d{7,8}");
       System.out.println(result);
       System.out.println("******************");

       str = "hello|world|java";
       String [] strs = str.split("\\|");
       for(int i=0;i<strs.length;i++){
           System.out.println(strs[i]);
       }

       System.out.println();

       str2 = "hello.world.java";
       String [] str2s = str2.split("\\.");
       for(int i=0;i<str2.length();i++){
           System.out.println(str2s[i]);

       }


   }
    /*
    boolean endwith(String suffix):测试字符串是否以指定的后缀结束
    boolean startwith(String prefix):测试字符惨是否以指定的前缀开始
    boolean stratwith(String prefix,int toffset):测试此字符串从指定索引开始的子字符串

    boolean contains(CharSequence s):当且仅当此字符串包含指定的char值序列时，返回true
    int indexOf(String str):返回指定子字符串在此字符串第一次出现处的索引
    int indexOf(String str,int fromIndex):返回指定子字符串再次字符串中第一次出现处的索引
    int LastIndexOf(String str):返回指定子字符串在此字符串最右边出现出的索引
    int LastIndexOf(String str,int fromIndex):返回指定子字符串中最后一次出现的处的索引
    注：indexOf和LastIndexOf方法如果未找到都是返回-1
     */

    @Test
    public void tese3(){
    String str1 = "helloworld";
    boolean b1 = str1.endsWith("rld");
        System.out.println(b1);//ture

        boolean b2 = str1.startsWith("He");
        System.out.println(b2);//false

        boolean b3 = str1.startsWith("ll", 2);
        System.out.println(b3);//true

        String str2 = "wor";
        System.out.println(str1.contains(str2));

        System.out.println(str1.indexOf("lol"));

        System.out.println(str1.indexOf("lo",5));
        String str3 = "helloworld" ;
        System.out.println(str3.lastIndexOf("or"));
        System.out.println(str3.lastIndexOf("or",6));

        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的一个str
        //情况二：不存在str
    }
    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 ="abc";
        String s4 = s3.concat("def");
        System.out.println(s4);//abcdef,很多时候直接使用+

        String s5 ="abc";
        String s6 = new String("abd");

        System.out.println(s5.compareTo(s6));//涉及到字符串排序

        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(2);
        System.out.println(s8);
        String s9 = s7.substring(2, 5);
        System.out.println(s9);

    }

    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));
//        System.out.println(s1.charAt(10));
        System.out.println(s1.isEmpty());//false
        String s2 = s1.toLowerCase();
        System.out.println(s1);//HelloWorld,s1不可变仍然为原来的字符串
        System.out.println(s2);//helloword，转换为小写

        String s3 = "he llo wor ld";
        String s4 = s3.trim();//取出首尾空格，搜索的时候用
        System.out.println("----"+s3+"---");
        System.out.println("----"+s4+"---");






    }
}
