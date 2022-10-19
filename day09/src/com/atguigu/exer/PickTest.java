package com.atguigu.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lzx
 * @create 2022-04-2022/4/23 15:36
 */
public class PickTest {
    //图片的加密
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("\\C:\\workspace_idea1\\JavaSenior\\day09\\敏secret.jpg");
            fos = new FileOutputStream("敏cancelsecret.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1){
               //对字节数据进行修改
                //错误的，buffer里的字节没变
    //            for (byte b : buffer){
    //                b = (byte)(b^5);
    //            }
                //正确的
                for (int i=0;i<len;i++){
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
