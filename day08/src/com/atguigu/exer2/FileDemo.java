package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author lzx
 * @create 2022-03-2022/3/27 16:52
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        File file = new File("E:\\网课图片\\hello.txt");
        //创建一个与file同目录下的另外一个文件，文件名为haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile){
            System.out.println("创建成功");
        }
    }
}
