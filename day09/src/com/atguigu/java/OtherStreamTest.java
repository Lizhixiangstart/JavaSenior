package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1，标准的输入，输出流
 * 2.打印流
 * 3.数据流
 * @author lzx
 * @create 2022-04-2022/4/23 20:12
 */
public class OtherStreamTest {

    /*
    * 1.标准的输入，输出流
    * 1.1
    * System.in:标准的输入流，默认从键盘输入
    * System.out:标准输出流，默认从控制台输出
    * 1.2
    * System类的setIn(InputStream is) / setOut(PrintStream ps)方式
    *
    * 1.3练习：
    * 从键盘输入字符串，要求将读取道德整行字符串转成大写输出，然后继续进行输入操作
    * 知道输入“e”或“exit”退出程序
    *
    * 方法一：使用Scanner实现，调用next()返回一个字符串
    * 方法二：使用System.in实现。-->转换流-->BufferedReader的readline()
    *
    * */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);


            while (true) {
                System.out.println("请输入字符串");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test1(){
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            String data ;
            while (true){
                System.out.println("请输入字符串");
                 data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data));
                System.out.println("程序结束");
                break;
            }

            String upperCase = data.toUpperCase();
            System.out.println(upperCase);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 2打印流：PrinStream和PrintWriter
    *
    * 2.1提供了一些列重载的print()和println()
    * */
    @Test
    public void test2(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("hello.txt");
            ps = new PrintStream(fos,true);
            if(ps != null){
                System.out.println(ps);
            }
            for (int i=0;i<=255;i++){
                System.out.print((char)i);
                if ( i%50 ==0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null){
                ps.close();
            }
        }
    }
    /*
    * 3数据流
    * 3.1 DataInputStream和DataOutputStream
    * 3.2作用：用于读取或去除基本数据类型的变量或字符串
    *
    * 练习：将内存中的字符串、基本数据类型的变量写出到文件中
    *
    * 注意：处理异常的话，任然应该使用try-catch-finally
    * */
    @Test
    public void test3() throws IOException {
        //1
    DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
    //2
    dos.writeUTF("李志祥");
    dos.flush();//刷新操作，将内存中的数据写入文件
    dos.writeInt(20);
    dos.flush();
    dos.writeBoolean(true);
    dos.flush();
    //3
    dos.close();

    }

/*
* 将文件中的基本数据类型和字符串读入到内存当中
* */
    @Test
    public void test4() throws IOException {
        //1
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        //2
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();
        System.out.println("name="+name);
        System.out.println("age="+age);
        System.out.println("isMale="+isMale);

        //3
        dis.close();

    }
}
