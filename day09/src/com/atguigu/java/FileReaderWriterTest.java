package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一、流的分类:
 * 1.操作数据单位：字节流、字符流
 * 2数据的流向：输入流、输出流
 * 3流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类             节点流(文件流)                                            缓冲流(处理流的一种)
 *InputStream           FileInputStream(read(byte[] cbuf))                  BufferedInputStream(read(byte[] buffer))
 *OutPutStream          FileOutputStream(write(byte[] cbuf,0,len))          BufferedOutputStream(write(byte[] buffer))
 *Reader                FileReader(read(char[] cbuf))                        BufferedReader(read(cahr[] cbuf/readLine()))
 *Writer                FileWriter(write(char[] cbuf,0,len))                BufferedWriter(write(char[] cbuf,o,len))
 * @author lzx
 * @create 2022-04-2022/4/22 23:38
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1 = new File("day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /*
    * 将day09下的hello.txt文件内容读入程序中，并输出到控制台
    *
    * 说明：
    * 1.read()的理解：返回读入的一个字符，如果达到文件末尾，返回-1
    * 2.异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
    * 3.读入的文件一定要存在，否则就会报FileNoteFoundException
    * */
  @Test
    public void testFileReader()  {
      FileReader fr = null;
      try {
          //1.实例化File类的对象，指明要操作的文件
          File file = new File("hello.txt");//相较于当前moudle
          //2/提供具体的流
          fr = new FileReader(file);

          //3数据的读入过程
          //read():返回读入的一个字符，如果达到文件末尾，返回-1
          //方式一：
//      int data = fr.read();
//      while (data != -1){
//          System.out.println((char)data);
//          data = fr.read();
//      }

          //方式二：
          int data ;
          while((data = fr.read()) != -1){
              System.out.println((char)data);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }finally {
          //4流的关闭操作
          try {
              if(fr != null){
                  fr.close();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
      }

  }
  //对read()方法的操作升级：使用read重载的方法
  @Test
    public void testFileReader1() throws IOException {
      FileReader fr = null;
      try {
          //1.File的实例化
          File file = new File("hello.txt");
          //2.FileReader流的实例化
          fr = new FileReader(file);
          //3.读入的具体操作细节
          //read(char[] cbuf):返回每次读入cbuf数组中的字符个数
          char[] cbuf = new char[5];
          int len;
          while ((len = fr.read(cbuf)) != -1){
//            错误写法
//              for(int i=0;i<cbuf.length;i++){
//                  System.out.println(cbuf[i]);
//              }

              //正确写法
              for(int i=0;i<len;i++){
                  System.out.println(cbuf[i]);
              }


              //方式二
              //错误的写法，对应着方式一的错误写法
//              String str = new String(cbuf);
//              System.out.print(str);
              //正确的
              String str = new String(cbuf,0,len
              );
          }
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if(fr != null) {
              //4.资源的关闭
              fr.close();
          }
      }

  }


  /*从内存中写出数据到硬盘的文件里

  说明：
  1输出操作对应的File可以不存在，如果不存在，在输出的过程中，会自动创建此文件
   2
        File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
        File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWriter(file,false)/FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件进行覆盖，而是对原有文件进行追加操作
  * */
  @Test
    public void testFileWriter()  {
    //1.提供File类的对象，指明写出到的文件
      FileWriter fw = null;
      try {
          File file = new File("hello.txt");

          //2.提供FileWriter的对象，用于数据的写出
          fw = new FileWriter(file,false);

          //3.写出操作
          fw.write("I have a dream\n");
          fw.write("I love you");
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if(fw != null) {
              //4.流资源的关闭
              try {
                  fw.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }

  }
@Test
    public void testFIleReaderFileWriter()  {
    FileReader fr = null;
    FileWriter fw = null;
    try {
        //1.创建File类的对象，指明读入和写出的文件
        File scrFile = new File("hello.txt");
        File destFile = new File("hello2.txt");
        //2.创建输入流和输出流的对象
        fr = new FileReader(scrFile);
        fw = new FileWriter(destFile);
        //3.数据读入和写出操作
        char[] cbuf = new char[5];
        int len;//记录每次读入到cbuf数组中字符的个数
        while ((len = fr.read(cbuf)) != -1){
            //每次写出len个字符
            fw.write(cbuf,0,len);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        //4.关闭流操作


        try {
            if(fw != null) {
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (fr != null) {
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

}
