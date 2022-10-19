package com.atguigu.java;

import java.io.*;

/**
 * @author lzx
 * @create 2022-04-2022/4/29 15:59
 */
public class KeyBoardTest {
    public static void main(String[] args) {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(System.in);
            osw = new OutputStreamWriter(new FileOutputStream("F:\\test.txt"));
            br = new BufferedReader(isr);

            while (true){
                System.out.println("请输入字符串");
                String str = br.readLine();
                if ("exit".equalsIgnoreCase(str) || "e".equalsIgnoreCase(str)){
                    System.out.println("程序结束");
                    break;
                }
                osw.write(str);

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
            if (osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }        }

    }
}
