package src.com.atguigu.TEst;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lzx
 * @create 2022-05-2022/5/20 16:24
 */
public class test2 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Java\\test");
       file.mkdirs();
       File file1 = new File(file,"test.txt");
        FileWriter fw = new FileWriter(file1);
        file.mkdirs();

        fw.write("1234");
        fw.write("\r");
        fw.write("\n");
        fw.write("李志祥");
        fw.close();
    }
}
