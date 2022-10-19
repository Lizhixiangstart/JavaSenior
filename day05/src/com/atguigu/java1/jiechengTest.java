package com.atguigu.java1;

/**
 * @author lzx
 * @create 2022-03-2022/3/11 12:35
 */
public class jiechengTest {
    public static void main(String[] args) {

        int number = 6;
        int sum =1;
        int result = 0;
        while(number>=1){
            for (int i=1;i<=number;i++){
                sum*=i;
            }
            number--;
            result +=sum;
            sum =1;
        }
        System.out.println(result);
    }
}
