package com.atguigu.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lzx
 * @create 2022-04-2022/4/28 0:17
 */
public class MyInputOutputTest {
    public static void main(String[] args) throws IOException {
        //1创建输入流(读),参数为用户从键盘输入的内容
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true){
            System.out.println("请输入字符串");
            String data = br.readLine();
            if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                System.out.println("程序结束");
                break;
            }
            String str = data.toUpperCase();
            System.out.println(str);

                System.out.println();
            }

        }

    }



